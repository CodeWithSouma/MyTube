package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;

    public VideoProcessor(VideoEncoder encoder) {
        this.encoder = encoder;
    }

    public void process(Video video) {
        encoder.encode(video);

        var database = new VideoDatabase();
        database.store(video);

        var emailService = new EmailService();
        emailService.sendEmail(video.getUser());
    }
}

