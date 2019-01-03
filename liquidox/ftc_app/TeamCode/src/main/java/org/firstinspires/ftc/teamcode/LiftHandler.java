package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LiftHandler {
    CRServo l;

    public LiftHandler(HardwareMap h) {
        this.l = h.crservo.get("Limb");
    }

    public void up() throws InterruptedException {
        this.l.setPower(0.2);
        Thread.sleep(1000);
        this.l.setPower(0);
    }
    public void down() throws InterruptedException {
        this.l.setPower(-0.2);
        Thread.sleep(1000);
        this.l.setPower(0);
    }

}
