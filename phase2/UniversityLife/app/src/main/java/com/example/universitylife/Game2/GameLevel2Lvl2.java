package com.example.universitylife.Game2;

import com.example.universitylife.Student;

import java.util.ArrayList;

public class GameLevel2Lvl2 extends GameLevel2Lvl1{
    // In this level the user can use the umbrella if they have bought one from the bookstore
    private boolean umbrellaOpen = false;
    public GameLevel2Lvl2(Student student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2Presenter presenter) {
        super(student, basket, FrameWidth, FrameHeight, fallingObjects, presenter);
    }

    /** set umbrella open, so that even if player eats an item with negative hp worth, score won't
     * be reduced
     */
    public void setUmbrellaOpen(){
      // student.getItems()[1] -=1;
        umbrellaOpen = true;
    }

    /** set the umbrella close, so that the blocking method can't be used anymore
     *
     */
    public void setUmbrellaClose(){
        umbrellaOpen = false;
    }

    /** get the umbrella status of the player
     *
     * @return boolean
     */
    public boolean getUmbrellaStatus(){
        return umbrellaOpen;
    }

    /** method of how the game works
     *
     * @param element the element of the fallingObjects list
     * @return the hp worth of the item eaten by the user
     */
    private int game(int element) {
        int result;
        FallingObject item = fallingObjects.get(element);
        item.fall(frameHeight, framewidth);
        boolean eat = basket.eatBall(item, frameHeight, framewidth);
        if (eat) {
            result = item.getScore_worth();
            if (umbrellaOpen){
                if (result < 0){
                    result = 0;
                }
            }
        }else{
            result = 0;
        }
        presenter.updateViewPosById(item.getFrontEndImageID());
        return result;
    }


    public void levelClear(){
        if (student.getCurrentLevel() == 2){
            student.incrementLevel();
        }
        student.incrementGpa(1);
        student.incrementCredit(5);
        student.incrementHp(score);
    }

    public void levelFail(){
        student.decrementGpa(1);
    }


}
