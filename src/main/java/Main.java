import com.gchaldu.coach.controller.CoachController;
import com.gchaldu.coach.model.repository.CoachRepository;
import com.gchaldu.coach.view.CoachView;
import com.gchaldu.exercise.controller.ExerciseController;
import com.gchaldu.exercise.model.repository.ExerciseRepository;
import com.gchaldu.exercise.view.ExerciseView;
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

        ExerciseRepository exerciseRepository = new ExerciseRepository();
        ExerciseController exerciseController = new ExerciseController(exerciseRepository);

        TrainingView trainingView = new TrainingView();
        CoachView coachView = new CoachView();
        ExerciseView exerciseView = new ExerciseView();

        Main.menu(trainingController, trainingView, coachController, coachView, exerciseController, exerciseView);
    }

    public static void menu(TrainingController trainingController,
                            TrainingView trainingView,
                            CoachController coachController,
                            CoachView coachView,
                            ExerciseController exerciseController,
                            ExerciseView exerciseView

    ){
        Scanner scanner = new Scanner(System.in);
        String choise;
        Boolean exit=true;
        while (exit){
            System.out.println("Select Options");
            System.out.println("1 - Training");
            System.out.println("2 - Coach");
            System.out.println("3 - Exercise");
            System.out.println("4 - Exit");
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
                    exerciseView.start(exerciseController);
                    break;
                }
                case "4":{
                    exit=false;
                    break;
                }
            }
        }
    }
}