package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private final SparkMax master =
        new SparkMax(Constants.Shooter.MASTER_ID, MotorType.kBrushless);

  /*private final SparkMax follower =
        new SparkMax(Constants.Shooter.FOLLOWER_ID, MotorType.kBrushless);

    public ShooterSubsystem() {
        follower.follow(master, true); // true = invert follower if needed
    }*/

    public void shoot() {
        master.set(Constants.Shooter.SPEED);
    }

    public void stop() {
        master.stopMotor();
    }
}

