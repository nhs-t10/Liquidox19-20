package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LiftHandler {
    CRServo latchS;
    DcMotor latchM;

    public LiftHandler(HardwareMap h) {
        this.latchS = h.crservo.get("Limb");
    }

    public void upArm() throws InterruptedException {
        this.latchS.setPower(0.2);
        latchM.setPower(0.2f);
        Thread.sleep(1000);
        this.latchS.setPower(0);
        latchM.setPower(0f);
    }
    public void downArm() throws InterruptedException {
        this.latchS.setPower(-0.2);
        latchM.setPower(-0.2f);
        Thread.sleep(1000);
        this.latchS.setPower(0);
        latchM.setPower(0f);
    }

}
