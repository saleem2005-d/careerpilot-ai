package com.careerpilot.backend.service;

import com.careerpilot.backend.analysis.ResumeAnalysisService;
import com.careerpilot.backend.dto.ResumeAnalysis;
import com.careerpilot.backend.entity.Resume;
import com.careerpilot.backend.parser.PdfParserService;
import com.careerpilot.backend.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UploadService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private PdfParserService pdfParserService;

    @Autowired
    private ResumeAnalysisService resumeAnalysisService;

    private static final String UPLOAD_DIR = "uploads";

    public UploadResult uploadResume(MultipartFile file) throws Exception {

        File uploadFolder = new File(UPLOAD_DIR);

        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String uniqueFileName =
                UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destination = new File(uploadFolder, uniqueFileName);

        System.out.println("Saving file to:");
        System.out.println(destination.getAbsolutePath());

        // Copy manually instead of transferTo()
        try (
                InputStream in = file.getInputStream();
                FileOutputStream out = new FileOutputStream(destination)
        ) {
            in.transferTo(out);
        }

        System.out.println("Saved: " + destination.exists());

        String extractedText = "";

        if ("application/pdf".equalsIgnoreCase(file.getContentType())) {

            extractedText = pdfParserService.extractText(
                    new FileInputStream(destination)
            );
        }

        Resume resume = new Resume();

        resume.setOriginalFileName(file.getOriginalFilename());
        resume.setStoredFileName(uniqueFileName);
        resume.setFileType(file.getContentType());
        resume.setFileSize(file.getSize());
        resume.setFilePath(destination.getAbsolutePath());
        resume.setExtractedText(extractedText);
        resume.setUploadedAt(LocalDateTime.now());

        Resume savedResume = resumeRepository.save(resume);

        ResumeAnalysis analysis =
                resumeAnalysisService.analyze(extractedText);

        return new UploadResult(savedResume, analysis);
    }
}