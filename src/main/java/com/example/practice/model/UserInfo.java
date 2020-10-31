package com.example.practice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Data
@Entity
@Table(name = "User_Info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "second_name", length = 50)
    private String secondName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "is_identified")
    private boolean isIdentified;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office officeId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private UserPosition positionId;

    @ManyToOne
    @JoinColumn(name = "citizenship_code")
    private Country citizenshipCode;

    @OneToOne(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserDoc userDoc;

    public UserInfo(){

    }

    public UserInfo(int id, String firstName, Office officeId) {
        this.id = id;
        this.firstName = firstName;
        this.officeId = officeId;
    }
}
