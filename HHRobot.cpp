#include "HHRobot.h"
#include "HHBase.h"
HHRobot::HHRobot():
  hhdrive(new WCDrive(3,1,4,2,-1,-1)),
  mainStick(new Extreme3dPro(1)){
  }
void HHRobot::Init(){
  printf("Initing\n");
  printf("Code Version: %f\n",0000.1);
}
//Main function used to handle periodic tasks on the robot
void HHRobot::Handler(){
  hhdrive->Update(4,mainStick->GetJoystickAxis("y"),mainStick->GetJoystickAxis("x")+mainStick->GetJoystickAxis("y"));
}
// vim: ts=2:sw=2:et
