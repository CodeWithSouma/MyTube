package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private NotificationService notificationService;
    private VideoDatabase database;

    public VideoProcessor(
            VideoEncoder encoder,
            NotificationService notificationService,
            VideoDatabase database
    ) {
        this.encoder = encoder;
        this.notificationService = notificationService;
        this.database = database;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.sendEmail(video.getUser());
    }
}

