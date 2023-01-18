package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.ToAcceptNotification;

public interface ToAcceptNotificationRepository extends JpaRepository<ToAcceptNotification,Integer> {

}
