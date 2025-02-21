package hu.gde.runnersdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final ShoeRepository shoeRepository;

    @Autowired
    public DataLoader(RunnerRepository runnerRepository, ShoeRepository shoeRepository) {
        this.runnerRepository = runnerRepository;
        this.shoeRepository = shoeRepository;
    }

    @Override
    public void run(String... args) {
        ShoeEntity shoeEntity = new ShoeEntity();
        shoeEntity.setShoeName("Jordan 1 - Lost And Found");
        shoeRepository.save(shoeEntity);

        // create default runner entity
        RunnerEntity runnerEntity = new RunnerEntity();
        runnerEntity.setRunnerName("Tomi");
        runnerEntity.setAveragePace(310);
        runnerEntity.setAge(20);

        // create default laptime entities and add them to the runner entity
        LapTimeEntity laptime1 = new LapTimeEntity();
        laptime1.setLapNumber(1);
        laptime1.setTimeSeconds(120);
        laptime1.setRunner(runnerEntity);

        LapTimeEntity laptime2 = new LapTimeEntity();
        laptime2.setLapNumber(2);
        laptime2.setTimeSeconds(110);
        laptime2.setRunner(runnerEntity);

        runnerEntity.getLaptimes().add(laptime1);
        runnerEntity.getLaptimes().add(laptime2);
        runnerEntity.setShoe(shoeEntity);

        runnerRepository.save(runnerEntity);

        ShoeEntity shoeEntity2 = new ShoeEntity();
        shoeEntity2.setShoeName("Yeezy 350 v1 - Pirate Black");
        shoeRepository.save(shoeEntity2);

        RunnerEntity runnerEntity2 = new RunnerEntity();
        runnerEntity2.setRunnerName("Zsuzsi");
        runnerEntity2.setAveragePace(290);
        runnerEntity2.setAge(24);

        // create default laptime entities and add them to the runner entity
        LapTimeEntity laptime3 = new LapTimeEntity();
        laptime3.setLapNumber(1);
        laptime3.setTimeSeconds(95);
        laptime3.setRunner(runnerEntity2);

        LapTimeEntity laptime4 = new LapTimeEntity();
        laptime4.setLapNumber(2);
        laptime4.setTimeSeconds(100);
        laptime4.setRunner(runnerEntity2);

        runnerEntity2.getLaptimes().add(laptime3);
        runnerEntity2.getLaptimes().add(laptime4);
        runnerEntity2.setShoe(shoeEntity2);

        runnerRepository.save(runnerEntity2);

        ShoeEntity shoeEntity3 = new ShoeEntity();
        shoeEntity3.setShoeName("Adidas Stan Smith");
        shoeRepository.save(shoeEntity3);

        RunnerEntity runnerEntity3 = new RunnerEntity();
        runnerEntity3.setRunnerName("Pál");
        runnerEntity3.setAveragePace(300);
        runnerEntity3.setAge(30);

        // create default laptime entities and add them to the runner entity
        LapTimeEntity laptime5 = new LapTimeEntity();
        laptime5.setLapNumber(1);
        laptime5.setTimeSeconds(140);
        laptime5.setRunner(runnerEntity3);

        LapTimeEntity laptime6 = new LapTimeEntity();
        laptime6.setLapNumber(2);
        laptime6.setTimeSeconds(170);
        laptime6.setRunner(runnerEntity3);

        runnerEntity3.getLaptimes().add(laptime5);
        runnerEntity3.getLaptimes().add(laptime6);
        runnerEntity3.setShoe(shoeEntity3);

        runnerRepository.save(runnerEntity3);
    }
}

