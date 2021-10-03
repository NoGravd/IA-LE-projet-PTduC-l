import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.Motor;

public class Detection {

	//Classe qui permet de detecter la nature, la distance et direction d'un obstacle à l'aide d'un 360 degres sur soit meme
	//A mettre à jour avec la classe moteur et Capteur
	
	
	private int directionFace = 0;
	private float[] distance360 = new float[360];
	
	private int directionObstacle = 0;
	private float distanceObstacle = 0;
	private boolean obstacleEstPalet = false;

	private Capteur capteurs = new Capteur();
	
	private BaseRegulatedMotor moteurC = Motor.C;
	
	
	public int getDirectionObstacle(){
		
		//Permet d'obtenir la direction en ° de l'obstacle
		
		return directionObstacle;
		
	}
	
	
	private void clearTableauDistance(){
		
		//Permet de remettre à 0 le tableau des distances 
		
		distance360 = new float[360];
		
	}
	
	private void actualiserDirectionFace(){
		
		//Permet d'avoir une direction toujours inférieur à 360
		
		if(directionFace >= 360){
			
			directionFace = directionFace - 360;
			
		}
		
	}
	
	public void tourSurSoiMemeDetection(){
		
		//Fait un tour sur soit meme est prends une mesure a chaque degres
		
		int i=0;
		clearTableauDistance();
		
		while(i<=360){
			
			moteurC.rotate(1);
			capteurs.demarrerLeCapteurUltraSon();
			capteurs.distanceOb();
			distance360[i] = capteurs.getDistanceOb();		
			i++;
		}
		
		actualiserDirectionFace();
	}
	
	public void directionDeLobstacle(){
		
		
		int i =0;
		float valeurPrec = distance360[0];
		
		while(i < 360){
			
			if(valeurPrec > distance360[i]){
				
				if(){				//Si c'est un pallet
				
					directionObstacle = i-1;
					distanceObstacle = distance360[i];
					obstacleEstPalet = true;
				
				}else{				//Si ce n'est pas un paller
					
					directionObstacle = i-1;
					distanceObstacle = distance360[i];
					obstacleEstPalet = false;		
				}
			}
			i++;
		}
	}
	
	
	
}