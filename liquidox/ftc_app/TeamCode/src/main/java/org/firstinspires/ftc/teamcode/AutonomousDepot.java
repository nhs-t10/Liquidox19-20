package org.firstinspires.ftc.teamcode;

public class AutonomousDepot extends AutonomousTesting {

    double power = 0.5;
   // double secCoef = 1;

    public void loop(){

        if(step == 1){
            unLatch();
            if(timer1 >= 5000){
                step++;
            }
        }
        if(step == 2){
            drive(0.5, 0.5, 0.5, 0.5);
            if(timer1 >= 10000){
                drive(0,0,0,0);
                step++;
            }
        }
        timer1 = System.currentTimeMillis();
//        if(current == currentState.Turning){
//            turn();
//        }
//        if(current. )


    }
}
