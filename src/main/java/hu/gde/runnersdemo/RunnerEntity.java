package hu.gde.runnersdemo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private long averagePace;
    private long age;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LapTimeEntity> laptimes = new ArrayList<>();

    @ManyToOne
    private ShoeEntity shoe;

    public ShoeEntity getShoe() {
        return shoe;
    }

    public void setShoe(ShoeEntity shoe) {
        this.shoe = shoe;
    }

    public RunnerEntity() {
    }

    public long getRunnerId() {
        return runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getAveragePace() {
        return averagePace;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public void setAveragePace(long averagePace) {
        this.averagePace = averagePace;
    }

    public List<LapTimeEntity> getLaptimes() {
        return laptimes;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}