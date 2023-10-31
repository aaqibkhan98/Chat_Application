package com.mercure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "group_user")
@IdClass(GroupRoleKey.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUser implements Serializable {

    @Id
    private int groupId;

    @Id
    private int userId;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    GroupEntity groupMapping;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity userMapping;

    private int role;

    @Override
    public int hashCode() {
        return Objects.hash(groupId, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GroupUser groupRoleKey = (GroupUser) obj;
        return groupId == groupRoleKey.groupId &&
                userId == groupRoleKey.userId;
    }
}
