//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import org.firstinspires.ftc.teamcode.Turning;
//import org.firstinspires.ftc.teamcode.BasicTankMode;
//
//@Autonomous
//public class AutonomousCrater extends AutonomousTesting {
//
//
//
//    /* WE STILL NEED TO INITIALIZE THE IMU, ASK PAUL WHAT WE HAVE OT DO FOR THAT */
//
//
//    public void loop() {
//
//        //init(); - not deleted because I don't want to mess up everything.
//
//        if (step == 1) {
//            unLatch();
//            if (timer1 >= 5000) {
//                step++;
//                drive(0, 0,0,0);
//            }
//        }
//
//        if (step == 2) {
//            drive(1,1,1,1);
//            if (timer1 >= 2000) {
//                step++;
//                drive(0, 0,0,0);
//            }
//
//        }
//
//        if (step==3) {
//            Turning.setDestination(90);
//            Turning.update();
//            if (Turning.getError < 3) {
//                step++;
//                drive(0, 0,0,0);
//            }
//        }
//
//    }
//}
//
//
