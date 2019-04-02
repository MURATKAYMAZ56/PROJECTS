package vlag;

/**
*
* Doel: Array to make all (hardcoded) flags
*
* @author C14b
*
*/

public class AnthemMaker {
	
	public AnthemMaker() {
		super();
	}
	
	public Anthem[] getAnthems() {
		Anthem[] anthems = new Anthem[7];
		
		Note[] dutchNotes = new Note [16];
		dutchNotes[0] = new Note(NoteName.D_LAAG, NoteDuration.KWART);
		dutchNotes[1] = new Note(NoteName.G, NoteDuration.KWART);
		dutchNotes[2] = new Note(NoteName.G, NoteDuration.KWART);
		dutchNotes[3] = new Note(NoteName.A, NoteDuration.EIGHT);
		dutchNotes[4] = new Note(NoteName.B, NoteDuration.EIGHT);
		dutchNotes[5] = new Note(NoteName.C, NoteDuration.EIGHT);
		dutchNotes[6] = new Note(NoteName.A, NoteDuration.EIGHT); 
		dutchNotes[7] = new Note(NoteName.B, NoteDuration.KWART);
		dutchNotes[8] = new Note(NoteName.A, NoteDuration.EIGHT); 
		dutchNotes[9] = new Note(NoteName.B, NoteDuration.EIGHT);
		dutchNotes[10] = new Note(NoteName.C, NoteDuration.KWART);  
		dutchNotes[11] = new Note(NoteName.B, NoteDuration.KWART);  
		dutchNotes[12] = new Note(NoteName.A, NoteDuration.EIGHT);
		dutchNotes[13] = new Note(NoteName.G, NoteDuration.EIGHT);
		dutchNotes[14] = new Note(NoteName.A, NoteDuration.KWART);
		dutchNotes[15] = new Note(NoteName.G, NoteDuration.HALF);
		Anthem dutch = new Anthem("Wilhelmus", dutchNotes);
		
		Note[] belgianNotes = new Note [12];	
		belgianNotes[0] = new Note(NoteName.F_LAAG, NoteDuration.SIXTEENTH);
		belgianNotes[1] = new Note(NoteName.D_LAAG, NoteDuration.EIGHT_PLUS);
		belgianNotes[2] = new Note(NoteName.E_LAAG, NoteDuration.SIXTEENTH);
		belgianNotes[3] = new Note(NoteName.F_LAAG, NoteDuration.KWART);
		belgianNotes[4] = new Note(NoteName.G, NoteDuration.EIGHT_PLUS);
		belgianNotes[5] = new Note(NoteName.A, NoteDuration.SIXTEENTH); 
		belgianNotes[6] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT_PLUS); 
		belgianNotes[7] = new Note(NoteName.A, NoteDuration.SIXTEENTH);
		belgianNotes[8] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT_PLUS);
		belgianNotes[9] = new Note(NoteName.D, NoteDuration.SIXTEENTH);
		belgianNotes[10] = new Note(NoteName.F_LAAG, NoteDuration.HALF);
		belgianNotes[11] = new Note(NoteName.F_LAAG, NoteDuration.KWART);
		Anthem belgian = new Anthem("La Brabanconne", belgianNotes);
		
		Note[] italianNotes = new Note [16];
		italianNotes[0] = new Note(NoteName.F_LAAG, NoteDuration.KWART);   
		italianNotes[1] = new Note(NoteName.F_LAAG, NoteDuration.EIGHT);   
		italianNotes[2] = new Note(NoteName.G, NoteDuration.EIGHT); 
		italianNotes[3] = new Note(NoteName.F_LAAG, NoteDuration.HALF); 
		italianNotes[4] = new Note(NoteName.D, NoteDuration.KWART); 
		italianNotes[5] = new Note(NoteName.D, NoteDuration.EIGHT); 
		italianNotes[6] = new Note(NoteName.DIS_ES, NoteDuration.EIGHT); 
		italianNotes[7] = new Note(NoteName.D, NoteDuration.HALF); 
		italianNotes[8] = new Note(NoteName.D, NoteDuration.KWART); 
		italianNotes[9] = new Note(NoteName.F, NoteDuration.EIGHT);
		italianNotes[10] = new Note(NoteName.DIS_ES, NoteDuration.EIGHT); 
		italianNotes[11] = new Note(NoteName.D, NoteDuration.HALF); 
		italianNotes[12] = new Note(NoteName.C, NoteDuration.KWART); 
		italianNotes[13] = new Note(NoteName.D, NoteDuration.EIGHT); 
		italianNotes[14] = new Note(NoteName.C, NoteDuration.EIGHT); 
		italianNotes[15] = new Note(NoteName.AIS_BES, NoteDuration.HALF); 
		Anthem italian = new Anthem("Degli Italiani", italianNotes);

		
		Note[] germanNotes = new Note [17];
		germanNotes[0] = new Note(NoteName.DIS_ES_LAAG, NoteDuration.KWART);  
		germanNotes[1] = new Note(NoteName.F_LAAG, NoteDuration.EIGHT);  
		germanNotes[2] = new Note(NoteName.G, NoteDuration.KWART);
		germanNotes[3] = new Note(NoteName.F_LAAG, NoteDuration.KWART);
		germanNotes[4] = new Note(NoteName.GIS_AS, NoteDuration.KWART);  
		germanNotes[5] = new Note(NoteName.G, NoteDuration.KWART); 
		germanNotes[6] = new Note(NoteName.F_LAAG, NoteDuration.EIGHT); 
		germanNotes[7] = new Note(NoteName.D_LAAG, NoteDuration.EIGHT);  
		germanNotes[8] = new Note(NoteName.DIS_ES_LAAG, NoteDuration.KWART);  
		germanNotes[9] = new Note(NoteName.C, NoteDuration.KWART); 
		germanNotes[10] = new Note(NoteName.AIS_BES, NoteDuration.KWART);
		germanNotes[11] = new Note(NoteName.GIS_AS, NoteDuration.KWART); 
		germanNotes[12] = new Note(NoteName.G, NoteDuration.KWART);
		germanNotes[13] = new Note(NoteName.F_LAAG, NoteDuration.KWART);
		germanNotes[14] = new Note(NoteName.G, NoteDuration.EIGHT);
		germanNotes[15] = new Note(NoteName.DIS_ES_LAAG, NoteDuration.EIGHT);
		germanNotes[16] = new Note(NoteName.AIS_BES, NoteDuration.HALF);
		Anthem german = new Anthem("Deutschlandlied", germanNotes);
		
		
		Note[] frenchNotes = new Note [18];
		frenchNotes[0] = new Note(NoteName.D_LAAG, NoteDuration.SIXTEENTH);
		frenchNotes[1] = new Note(NoteName.D_LAAG, NoteDuration.EIGHT_PLUS);  
		frenchNotes[2] = new Note(NoteName.D_LAAG, NoteDuration.SIXTEENTH);
		frenchNotes[3] = new Note(NoteName.G, NoteDuration.KWART);
		frenchNotes[4] = new Note(NoteName.G, NoteDuration.KWART);
		frenchNotes[5] = new Note(NoteName.A, NoteDuration.KWART);
		frenchNotes[6] = new Note(NoteName.A, NoteDuration.KWART);
		frenchNotes[7] = new Note(NoteName.D, NoteDuration.KWART_PLUS);
		frenchNotes[8] = new Note(NoteName.B, NoteDuration.EIGHT);
		frenchNotes[9] = new Note(NoteName.G, NoteDuration.EIGHT, 125); 
		frenchNotes[10] = new Note(NoteName.G, NoteDuration.SIXTEENTH);
		frenchNotes[11] = new Note(NoteName.B, NoteDuration.EIGHT_PLUS); 
		frenchNotes[12] = new Note(NoteName.G, NoteDuration.SIXTEENTH);
		frenchNotes[13] = new Note(NoteName.E_LAAG, NoteDuration.KWART); 
		frenchNotes[14] = new Note(NoteName.C, NoteDuration.HALF);
		frenchNotes[15] = new Note(NoteName.A, NoteDuration.EIGHT_PLUS); 
		frenchNotes[16] = new Note(NoteName.FIS_GES, NoteDuration.SIXTEENTH); 
		frenchNotes[17] = new Note(NoteName.G, NoteDuration.HALF); 
		Anthem french = new Anthem("La Marseillaise", frenchNotes);
		
		
		Note[] austrianNotes = new Note [10];
		austrianNotes[0] = new Note(NoteName.A, NoteDuration.HALF); 
		austrianNotes[1] = new Note(NoteName.G, NoteDuration.KWART); 
		austrianNotes[2] = new Note(NoteName.E_LAAG, NoteDuration.HALF);
		austrianNotes[3] = new Note(NoteName.G, NoteDuration.EIGHT);
		austrianNotes[4] = new Note(NoteName.A, NoteDuration.EIGHT);
		austrianNotes[5] = new Note(NoteName.B, NoteDuration.HALF);
		austrianNotes[6] = new Note(NoteName.A, NoteDuration.KWART);
		austrianNotes[7] = new Note(NoteName.A, NoteDuration.EIGHT);
		austrianNotes[8] = new Note(NoteName.G, NoteDuration.EIGHT);
		austrianNotes[9] = new Note(NoteName.G, NoteDuration.KWART);
		Anthem austrian = new Anthem("Land der Berge", austrianNotes);
		
		
		Note[] spanishNotes = new Note [22];
		spanishNotes[0] = new Note(NoteName.AIS_BES, NoteDuration.KWART); 
		spanishNotes[1] = new Note(NoteName.F_LAAG, NoteDuration.KWART); 
		spanishNotes[2] = new Note(NoteName.D, NoteDuration.KWART);
		spanishNotes[3] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT);
		spanishNotes[4] = new Note(NoteName.F, NoteDuration.EIGHT); 
		spanishNotes[5] = new Note(NoteName.DIS_ES, NoteDuration.EIGHT); 
		spanishNotes[6] = new Note(NoteName.D, NoteDuration.EIGHT);
		spanishNotes[7] = new Note(NoteName.C, NoteDuration.EIGHT);
		spanishNotes[8] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT);
		spanishNotes[9] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT);
		spanishNotes[10] = new Note(NoteName.A, NoteDuration.EIGHT);
		spanishNotes[11] = new Note(NoteName.G, NoteDuration.EIGHT);
		spanishNotes[12] = new Note(NoteName.F_LAAG, NoteDuration.EIGHT);
		spanishNotes[13] = new Note(NoteName.AIS_BES, NoteDuration.KWART);
		spanishNotes[14] = new Note(NoteName.C, NoteDuration.KWART);
		spanishNotes[15] = new Note(NoteName.D, NoteDuration.KWART, 250);
		spanishNotes[16] = new Note(NoteName.F, NoteDuration.EIGHT);
		spanishNotes[17] = new Note(NoteName.DIS_ES, NoteDuration.EIGHT); 
		spanishNotes[18] = new Note(NoteName.D, NoteDuration.EIGHT);
		spanishNotes[19] = new Note(NoteName.C, NoteDuration.EIGHT);
		spanishNotes[20] = new Note(NoteName.AIS_BES, NoteDuration.EIGHT);
		spanishNotes[21] = new Note(NoteName.F, NoteDuration.KWART_PLUS);
		Anthem spanish = new Anthem("Marcha Real", spanishNotes);
		
		anthems[0] = dutch;
		anthems[1] = belgian;
		anthems[2] = italian;
		anthems[3] = german;
		anthems[4] = french;
		anthems[5] = austrian;
		anthems[6] = spanish;
		
		return anthems;
	}
	
	
}
