package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.ReminderNotification;

public interface ReminderNotificationRepository extends JpaRepository<ReminderNotification, Integer> {

}
