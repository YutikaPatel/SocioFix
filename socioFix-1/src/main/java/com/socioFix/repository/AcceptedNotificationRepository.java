package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.AcceptedNotification;


public interface AcceptedNotificationRepository extends JpaRepository<AcceptedNotification,Integer>{

}
