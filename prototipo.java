/*
* Juan Sebastian Gomez
* Edwin Bedoya Vargas
*
*/
import lejos.nxt.LCD; // Se importan algunas librerias con las que estamos jugando no son fijas 
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.nxt.;
import lejos.robotics.TachoMotor;
import lejos.robotics.navigation.TachoPilot;

public class RobotPilot extends TachoPilot{
        protected Motor left;
        protected Motor right;
        protected TouchSensor Ufront;

        public RobotPilot(float rightRueda, TachoMotor leftMotor, TachoMotor rightMotor,boolean reverse) {
                super( rightRueda, leftMotor, rightMotor,reverse);
        }
        
        public RobotPilot(float diametroRueda, TachoMotor leftMotor, TachoMotor rightMotor) {
                
                super(diametroRueda, leftMotor, rightMotor);
                this.left = (Motor) leftMotor;
                this.right = (Motor) rightMotor;
        }
        
        public RobotPilot(float diametroRueda, float, TachoMotor leftMotor, TachoMotor rightMotor, TouchSensor front) {
                super(diametroRueda, leftMotor, rightMotor);
                this.left = (Motor) leftMotor;
                this.right = (Motor) rightMotor;
                this.Uleft = left;
                this.Uright = right;
                this.Ufront = front;
        }
        
        public void adelante(){
                
                left.adelante();
                right.adelante();
                
        }
        
        public boolean corregir(){
                left.stop();
                right.stop();
                double range = 0;
                int leftd = Uleft.getDistance();// Distancia izquierda
                int rightd = Uright.getDistance(); //Distancia derecha
                LCD.clearDisplay(); // Limpia la pantalla del robot
                LCD.drawString(leftd + "\n" + rightd + "\n" + frontd, 2, 2);// Imprime las distancia
                LCD.refresh();

                        if (leftd>=rightd)
                        {
                                left.rotate(45); //Para que el robot gire
                                this.travel(-3);
                                left.rotate(-55);
                                this.travel(3);
                        }
                        else {
                                right.rotate(-45);
                                this.travel(-3);
                                right.rotate(55);
                                this.travel(3);
                        }
                
                while(left.isMoving()||right.isMoving()){}
        }
        
        public void rotate(float num){
                super.rotate(num);
        }       
}
