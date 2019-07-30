package TetrisGame;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tetris extends Applet
        implements Runnable
{
    Thread clock;

    Image off; // 메모리 상의 가상화면
    Graphics offG;

    Random r;

    boolean[][] map;
    Color[] colorType;
    Color[][] colorMap;

    int blockType;
    int[] blockX;
    int[] blockY;
    int blockPos;

    int score;
    int delayTime;
    boolean runGame;

    AudioClip turnAudio;
    AudioClip deleteAudio;
    AudioClip gameOverAudio;

    public void init()
    {
        // 메모리 상에 가상화면 만들기
        off= createImage(181, 316);
        offG= off.getGraphics();
        offG.setColor(Color.white);
        offG.fillRect(0,0,192,192);

        turnAudio= getAudioClip(getCodeBase(), "turn.au");
        deleteAudio= getAudioClip(getCodeBase(), "delete.au");
        gameOverAudio= getAudioClip(getCodeBase(), "gameover.au");

        map= new boolean[12][21];
        colorMap= new Color[12][21];
        colorType= new Color[7];
        setColorType();

        blockX= new int[4];
        blockY= new int[4];
        blockPos= 0;

        r= new Random();
        blockType= Math.abs(r.nextInt() % 7);
        setBlockXY(blockType);

        drawBlock();
        drawMap();
        drawGrid();

        score= 0;
        delayTime=1000;
        runGame= true;

        this.requestFocus();

        addKeyListener(new MyKeyHandler());
    }

    public void setColorType()
    {
        colorType[0]= new Color(65,228,82);
        colorType[1]= new Color(58,98,235);
        colorType[2]= new Color(128,0,64);
        colorType[3]= new Color(255,35,31);
        colorType[4]= new Color(68,17,111);
        colorType[5]= new Color(246,118,57);
        colorType[6]= new Color(224,134,4);
    }

    public void setBlockXY(int type)
    {
        switch(type){
            case 0:
                blockX[0]= 5; blockY[0]= 0;
                blockX[1]= 6; blockY[1]= 0;
                blockX[2]= 5; blockY[2]= 1;
                blockX[3]= 6; blockY[3]= 1;
                break;
            case 1:
                blockX[0]= 6; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 1;
                blockX[2]= 6; blockY[2]= 1;
                blockX[3]= 7; blockY[3]= 1;
                break;
            case 2:
                blockX[0]= 7; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 1;
                blockX[2]= 6; blockY[2]= 1;
                blockX[3]= 7; blockY[3]= 1;
                break;
            case 3:
                blockX[0]= 5; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 1;
                blockX[2]= 6; blockY[2]= 1;
                blockX[3]= 7; blockY[3]= 1;
                break;
            case 4:
                blockX[0]= 5; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 1;
                blockX[2]= 6; blockY[2]= 1;
                blockX[3]= 6; blockY[3]= 2;
                break;
            case 5:
                blockX[0]= 6; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 1;
                blockX[2]= 6; blockY[2]= 1;
                blockX[3]= 5; blockY[3]= 2;
                break;
            case 6:
                blockX[0]= 4; blockY[0]= 0;
                blockX[1]= 5; blockY[1]= 0;
                blockX[2]= 6; blockY[2]= 0;
                blockX[3]= 7; blockY[3]= 0;
                break;
        }
    }

    public void start()
    {
        if(clock==null){
            clock= new Thread(this);
            clock.start();  // 시계 시작
        }
    }

    public void paint(Graphics g)
    {
        // 가상화면을 실제화면에 출력
        g.drawImage(off, 0, 0, this);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void run()
    {
        while(true)
        {
            try{
                clock.sleep(delayTime);
            }catch(InterruptedException ie){}

            dropBlock();

            if(runGame){
                drawBlock();
                drawMap();
                drawGrid();
            }else{
                drawScore();
            }

            repaint(); // paint() 호출
        }
    }

    public void drawScore()
    {
        offG.setColor(Color.white);
        offG.fillRect(35, 120, 110, 70);
        offG.setColor(Color.black);
        offG.drawRect(40, 125, 100, 60);
        offG.setColor(Color.red);
        offG.drawString("Game Over !", 56, 150);
        offG.setColor(Color.blue);
        offG.drawString("Score: "+score, 56, 170);
    }

    public void dropBlock()
    {
        removeBlock();

        if(checkDrop()){
            for(int i=0; i<4; i++){
                blockY[i]= blockY[i]+1;
            }
        }else{
            drawBlock();
            nextBlock();
        }
    }

    public void delLine()
    {
        boolean delOk;

        for(int row=20; row>=0; row--){
            delOk= true;
            for(int col=0; col<12; col++){
                if(!map[col][row]) delOk= false;
            }

            if(delOk){
                deleteAudio.play();
                score+=10; // 점수 계산

                if(score<1000){  // 속도 조절
                    delayTime= 1000 - score;
                }else{
                    delayTime=0;
                }

                for(int delRow=row; delRow>0; delRow--){
                    for(int delCol=0; delCol<12; delCol++){
                        map[delCol][delRow]= map[delCol][delRow-1];
                        colorMap[delCol][delRow]= colorMap[delCol][delRow-1];
                    }
                }
                for(int i=0; i<12; i++){
                    map[0][i]= false;
                    colorMap[0][i]= Color.white;
                }
                row++;
            }
        }
    }

    public void nextBlock()
    {
        blockType= Math.abs(r.nextInt() % 7);
        blockPos= 0;
        delLine();
        setBlockXY(blockType);
        checkGameOver();
    }

    public void checkGameOver()
    {
        for(int i=0; i<4; i++){
            if(map[blockX[i]][blockY[i]]){
                if(runGame){
                    gameOverAudio.play();

                    runGame= false;
                }
            }
        }
    }

    public void removeBlock()
    {
        for(int i=0; i<4; i++){
            map[blockX[i]][blockY[i]]= false;
            colorMap[blockX[i]][blockY[i]]= Color.white;
        }
    }

    public boolean checkDrop()
    {
        boolean dropOk= true;

        for(int i=0; i<4; i++){
            if((blockY[i]+1)!=21){
                if(map[blockX[i]][blockY[i]+1]) dropOk= false;
            }else{
                dropOk= false;
            }
        }

        return dropOk;
    }

    public void drawBlock()
    {
        for(int i=0; i<4; i++){
            map[blockX[i]][blockY[i]]= true;
            colorMap[blockX[i]][blockY[i]]= colorType[blockType];
        }
    }

    public void drawMap()
    {
        for(int i=0; i<12; i++){
            for(int j=0; j<21; j++){
                if(map[i][j]){
                    offG.setColor(colorMap[i][j]);
                    offG.fillRect(i*15, j*15, 15, 15);
                }else{
                    offG.setColor(Color.white);
                    offG.fillRect(i*15, j*15, 15, 15);
                }
            }
        }
    }

    public void drawGrid()
    {
        offG.setColor(new Color(190,190,190));

        for(int i=0; i<12; i++){
            for(int j=0; j<21; j++){
                offG.drawRect(i*15, j*15, 15, 15);
            }
        }
    }

    public void stop()
    {
        if((clock!=null)&&(clock.isAlive())){
            clock=null; // 시계 정지(없앰)
        }
    }

    class MyKeyHandler extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            int keyCode= (int)e.getKeyCode();

            if(keyCode==KeyEvent.VK_LEFT){
                if(checkMove(-1)){
                    for(int i=0; i<4; i++){
                        blockX[i]= blockX[i]-1;
                    }
                }
            }

            if(keyCode==KeyEvent.VK_RIGHT){
                if(checkMove(1)){
                    for(int i=0; i<4; i++){
                        blockX[i]= blockX[i]+1;
                    }
                }
            }

            if(keyCode==KeyEvent.VK_DOWN){
                removeBlock();

                if(checkDrop()){
                    for(int i=0; i<4; i++){
                        blockY[i]= blockY[i]+1;
                    }
                }else{
                    drawBlock();
                }
            }

            if(keyCode==KeyEvent.VK_UP){
                int[] tempX= new int[4];
                int[] tempY= new int[4];

                for(int i=0; i<4; i++){
                    tempX[i]= blockX[i];
                    tempY[i]= blockY[i];
                }

                removeBlock();
                turnBlock();

                if(checkTurn()){
                    turnAudio.play();

                    if(blockPos<4){
                        blockPos++;
                    }else{
                        blockPos= 0;
                    }
                }else{
                    for(int i=0; i<4; i++){
                        blockX[i]= tempX[i];
                        blockY[i]= tempY[i];
                        map[blockX[i]][blockY[i]]= true;
                        colorMap[blockX[i]][blockY[i]]= colorType[blockType];
                    }
                }
            }

            drawBlock();
            drawMap();
            drawGrid();
            repaint();
        }

        public boolean checkTurn()
        {
            boolean turnOk= true;

            for(int i=0; i<4; i++){
                if((blockX[i]>=0)&&(blockX[i]<12)&&(blockY[i]>=0)&&(blockY[i]<21)){
                    if(map[blockX[i]][blockY[i]]) turnOk= false;
                }else{
                    turnOk= false;
                }
            }

            return turnOk;
        }

        public boolean checkMove(int dir)
        {
            boolean moveOk= true;

            removeBlock();

            for(int i=0; i<4; i++){
                if(((blockX[i]+dir)>=0)&&((blockX[i]+dir)<12)){
                    if(map[blockX[i]+dir][blockY[i]]) moveOk= false;
                }else{
                    moveOk= false;
                }
            }

            if(!moveOk) drawBlock();

            return moveOk;
        }


        public void turnBlock()
        {
            switch(blockType){
                case 1:
                    switch(blockPos){
                        case 0:
                            blockX[0]= blockX[0]; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]+1;
                            break;
                        case 1:
                            blockX[0]= blockX[0]-1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]+1; blockY[2]= blockY[2]-1;
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]-1;
                            break;
                        case 2:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2]+1;
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]+1;
                            break;
                        case 3:
                            blockX[0]= blockX[0]; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]-1; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]+1; blockY[3]= blockY[3]-1;
                            break;
                    }
                    break;
                case 2:
                    switch(blockPos){
                        case 0:
                            blockX[0]= blockX[0]-2; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]+1;
                            break;
                        case 1:
                            blockX[0]= blockX[0]; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]+1; blockY[2]= blockY[2]-1;
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]-1;
                            break;
                        case 2:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]-1; blockY[2]= blockY[2]+2;
                            blockX[3]= blockX[3]+2; blockY[3]= blockY[3]+1;
                            break;
                        case 3:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]; blockY[2]= blockY[2]-1;
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]-1;
                            break;
                    }
                    break;
                case 3:
                    switch(blockPos){
                        case 0:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]-1; blockY[2]= blockY[2]+1;
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]+1;
                            break;
                        case 1:
                            blockX[0]= blockX[0]-2; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]+1; blockY[2]= blockY[2]-2;
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]-1;
                            break;
                        case 2:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1];
                            blockX[2]= blockX[2]-1; blockY[2]= blockY[2]+1;
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]+1;
                            break;
                        case 3:
                            blockX[0]= blockX[0]; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]+1; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]+2; blockY[3]= blockY[3]-1;
                            break;
                    }
                    break;
                case 4:
                    switch(blockPos){
                        case 0:
                        case 2:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+2; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]-1; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]-1;
                            break;
                        case 1:
                        case 3:
                            blockX[0]= blockX[0]-1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-2; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]+1; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]; blockY[3]= blockY[3]+1;
                            break;
                    }
                    break;
                case 5:
                    switch(blockPos){
                        case 0:
                        case 2:
                            blockX[0]= blockX[0]-1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]+2; blockY[3]= blockY[3]-1;
                            break;
                        case 1:
                        case 3:
                            blockX[0]= blockX[0]+1; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2];
                            blockX[3]= blockX[3]-2; blockY[3]= blockY[3]+1;
                            break;
                    }
                    break;
                case 6:
                    switch(blockPos){
                        case 0:
                        case 2:
                            blockX[0]= blockX[0]+2; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]+1; blockY[1]= blockY[1]+1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2]+2;
                            blockX[3]= blockX[3]-1; blockY[3]= blockY[3]+3;
                            break;
                        case 1:
                        case 3:
                            blockX[0]= blockX[0]-2; blockY[0]= blockY[0];
                            blockX[1]= blockX[1]-1; blockY[1]= blockY[1]-1;
                            blockX[2]= blockX[2]; blockY[2]= blockY[2]-2;
                            blockX[3]= blockX[3]+1; blockY[3]= blockY[3]-3;
                            break;
                    }
                    break;
            }
        }
    }
}

