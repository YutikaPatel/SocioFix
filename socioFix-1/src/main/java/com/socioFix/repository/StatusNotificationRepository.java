package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.StatusNotification;

public interface StatusNotificationRepository  extends JpaRepository<StatusNotification,Integer>{

}
