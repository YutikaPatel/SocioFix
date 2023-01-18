package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
