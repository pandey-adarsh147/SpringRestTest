package com.augylabs.core.repository;

import com.augylabs.core.domain.ChatLogs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adarshpandey on 12/5/14.
 */
@Repository
public interface ChatLogRepository extends JpaRepository<ChatLogs, Integer> {

    @Query("select log from ChatLogs log where log.username = :username and log.id >= :messageID order by log.timestamp DESC")
    List<ChatLogs> findAll(@Param("username") String username, @Param("messageID") int messageId, Pageable pageable);
}
