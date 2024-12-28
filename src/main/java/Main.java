import com.gchaldu.training.controller.TrainingController;
import com.gchaldu.training.model.repository.TrainingRepository;
import com.gchaldu.training.view.TrainingView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainingRepository trainingRepository = new TrainingRepository();
        TrainingController trainingController = new TrainingController(trainingRepository);
        TrainingView trainingView = new TrainingView();
        Main.menu(trainingController, trainingView);
    }

    public static void menu(TrainingController trainingController, TrainingView trainingView){
        Scanner scanner = new Scanner(System.in);
        String choise;
        Boolean exit=true;
        while (exit){
            System.out.println("Select Options");
            System.out.println("1 - Training");
            System.out.println("2 - Exit");
            choise = scanner.nextLine();
            switch (choise){
                case "1":{
                    trainingView.start(trainingController);
                    break;
                }
                case "2":{
                    exit=false;
                    break;
                }
            }
        }
    }
}