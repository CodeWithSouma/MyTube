package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private NotificationService notificationService;
    private VideoDatabase videoDatabase;

    public VideoProcessor(VideoEncoder encoder, NotificationService notificationService, VideoDatabase videoDatabase) {
        this.encoder = encoder;
        this.notificationService = notificationService;
        this.videoDatabase = videoDatabase;
    }

    public void process(Video video) {
        encoder.encode(video);
        videoDatabase.store(video);
        notificationService.sendEmail(video.getUser());
    }
}

