package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.UpvotedNotification;

public interface UpvotedNotificationRepository extends JpaRepository<UpvotedNotification, Integer> {

}
