package in.strikes.hibernateDemo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(precision = 5,scale = 2)
    private BigDecimal percentage;

    @Column(
            unique = true,
            nullable = false,
            length = 150
    )
    private String email;

    private int age;

    @ElementCollection
    @CollectionTable(
            name="student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @Lob
    private String profileDescription;

    @Transient
    private String displayName;

    @Convert(converter = BooleanToStringConverter.class)
    private boolean isMonitor;

    private LocalDateTime createdAt;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo" ,
//                    column = @Column(name = "current_houseNo")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "current_street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "current_city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "current_state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "current_pincode")
//            )
//    })
//    private Address currentAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo" ,
//                    column = @Column(name = "permanent_houseNo")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "permanent_street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "permanent_city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "permanent_state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "permanent_pincode")
//            )
//    })
//    private Address permanentAddress;

    public Student() {
    }



//    public Student(Long id, String name, BigDecimal percentage, String email, int age, LocalDate dateOfBirth, StudentStatus studentStatus, String profileDescription, String displayName, boolean isMonitor, LocalDateTime createdAt, Address currentAddress, Address permanentAddress) {
//        this.id = id;
//        this.name = name;
//        this.percentage = percentage;
//        this.email = email;
//        this.age = age;
//        this.dateOfBirth = dateOfBirth;
//        this.studentStatus = studentStatus;
//        this.profileDescription = profileDescription;
//        this.displayName = displayName;
//        this.isMonitor = isMonitor;
//        this.createdAt = createdAt;
//        this.currentAddress = currentAddress;
//        this.permanentAddress = permanentAddress;
//    }
//
//    public Student(String name, String email, int age) {
//        this.name = name;
//        this.email = email;
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getPercentage() {
//        return percentage;
//    }
//
//    public void setPercentage(BigDecimal percentage) {
//        this.percentage = percentage;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public StudentStatus getStudentStatus() {
//        return studentStatus;
//    }
//
//    public void setStudentStatus(StudentStatus studentStatus) {
//        this.studentStatus = studentStatus;
//    }
//
//    public String getProfileDescription() {
//        return profileDescription;
//    }
//
//    public void setProfileDescription(String profileDescription) {
//        this.profileDescription = profileDescription;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public boolean isMonitor() {
//        return isMonitor;
//    }
//
//    public void setMonitor(boolean monitor) {
//        isMonitor = monitor;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }
//
//    public Address getPermanentAddress() {
//        return permanentAddress;
//    }
//
//    public void setPermanentAddress(Address permanentAddress) {
//        this.permanentAddress = permanentAddress;
//    }


    public Student(Long id, String name, BigDecimal percentage, String email, int age, Set<String> skills, LocalDate dateOfBirth, StudentStatus studentStatus, String profileDescription, String displayName, boolean isMonitor, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.email = email;
        this.age = age;
        this.skills = skills;
        this.dateOfBirth = dateOfBirth;
        this.studentStatus = studentStatus;
        this.profileDescription = profileDescription;
        this.displayName = displayName;
        this.isMonitor = isMonitor;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isMonitor() {
        return isMonitor;
    }

    public void setMonitor(boolean monitor) {
        isMonitor = monitor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
