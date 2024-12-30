import com.gchaldu.coach.controller.CoachController;
import com.gchaldu.coach.model.repository.CoachRepository;
import com.gchaldu.coach.view.CoachView;
import com.gchaldu.training.controller.TrainingController;
import com.gchaldu.training.model.repository.TrainingRepository;
import com.gchaldu.training.view.TrainingView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainingRepository trainingRepository = new TrainingRepository();
        TrainingController trainingController = new TrainingController(trainingRepository);

        CoachRepository coachRepository = new CoachRepository();
        CoachController coachController = new CoachController(coachRepository);

        TrainingView trainingView = new TrainingView();
        CoachView coachView = new CoachView();

        Main.menu(trainingController, trainingView, coachController, coachView);
    }

    public static void menu(TrainingController trainingController,
                            TrainingView trainingView,
                            CoachController coachController,
                            CoachView coachView

    ){
        Scanner scanner = new Scanner(System.in);
        String choise;
        Boolean exit=true;
        while (exit){
            System.out.println("Select Options");
            System.out.println("1 - Training");
            System.out.println("2 - Coach");
            System.out.println("3 - Exit");
            choise = scanner.nextLine();
            switch (choise){
                case "1":{
                    trainingView.start(trainingController);
                    break;
                }
                case "2":{
                    coachView.start(coachController);
                    break;
                }
                case "3":{
                    exit=false;
                    break;
                }
            }
        }
    }
}