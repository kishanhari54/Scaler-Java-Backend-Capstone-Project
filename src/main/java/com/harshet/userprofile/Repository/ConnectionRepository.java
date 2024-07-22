package com.harshet.userprofile.Repository;

import com.harshet.userprofile.Models.UserConnections;
import com.harshet.userprofile.Models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConnectionRepository extends JpaRepository<UserConnections, Long>
{
    List<UserConnections> findByUser(UserProfile user);
    List<UserConnections> findByFriendAndStatus(UserProfile friend, String status);
}
