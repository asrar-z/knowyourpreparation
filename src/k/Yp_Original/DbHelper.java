package k.Yp_Original;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "KYP";
	// tasks table name
	public String TABLE_NAME1="Capps";
	public String TABLE_NAME2="Probability";
	public String TABLE_NAME3="POT";
	public String TABLE_NAME4="TAW";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private static final String KEY_SOL= "solution";
	private SQLiteDatabase dbase;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
			}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_QUES+ " TEXT, " 
				+ KEY_ANSWER+ " TEXT, "
				+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "
				+KEY_OPTC+" TEXT, "
				+KEY_SOL+" TEXT)";
		db.execSQL(sql);
		 sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_QUES+ " TEXT, " 
				+ KEY_ANSWER+ " TEXT, "
				+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "
				+KEY_OPTC+" TEXT, "
				+KEY_SOL+" TEXT)";
		db.execSQL(sql);
		 sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_QUES+ " TEXT, " 
				+ KEY_ANSWER+ " TEXT, "
				+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "
				+KEY_OPTC+" TEXT, "
				+KEY_SOL+" TEXT)";
		db.execSQL(sql);
		 sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME4 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_QUES+ " TEXT, " 
				+ KEY_ANSWER+ " TEXT, "
				+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "
				+KEY_OPTC+" TEXT, "
				+KEY_SOL+" TEXT)";
		db.execSQL(sql);

			addQuestions1();

			addQuestions2();
	
			addQuestions3();
		
			addQuestions4();
		
		

	}
	
	
	public void addQuestions1()
	{
		String s="Capps";
		Question q1=new Question("#include<stdio.h>\n main(){\nint x = 10, y = 20, z = 5, i;\ni = x < y < z;\n printf(\"%d\\n\", i);}\n","0","1","Error","B","Since x < y turns to be TRUE it is replaced by 1." +
								 "Then 1 < z is compared and to be TRUE. The 1 is assigned to i.");
		this.addQuestion(q1,s);
		
		Question q2=new Question("#include<stdio.h> \nmain(){	\nint a[5] = {2, 3};\n	printf(\"%d, %d, %d\", a[2], a[3], a[4]);}","Garbage Values","2, 3, 3","0, 0, 0","C","C is the ans.initialized to 0.");
		this.addQuestion(q2,s);
		
		Question q3=new Question("Which of the following correctly represents a long double constant?"
				,"6.68","6.68L","6.68LF","B","6.68L is long double constant. ");
		this.addQuestion(q3,s);
		
		Question q4=new Question("Which of the following is the correct usage of conditional operators used in C?"
				,"a>b ? c=30 : c=40;","return (a>b)?(a:b)","max = a>b ? a>c?a:c:b>c?b:c","C"," C is the ans.it uses nested conditional operator, this is logic for finding greatest number out of three numbers.");
		this.addQuestion(q4,s);
		
		Question q5=new Question("OUTPUT ? printf(\"%x\\n\", -2<<2);"
				,"ffff","0","fff8","C","-2 is: 11111111 11111110.After left shifting it by 2 bits we obtain:fff8");
		this.addQuestion(q5,s);
		
		Question q6=new Question("OUTPUT ?  printf(5+\"Good Morning\\n\");"
				,"Morning","Good Morning","Good","A"," skips the 5 characters and prints Morning");
		this.addQuestion(q6,s);
		
		Question q7=new Question("How many bytes are occupied by near, far and huge pointers (DOS)?"
				,"near=2 far=4 huge=4","near=4 far=8 huge=8","near=4 far=4 huge=8","A","near=2, far=4 and huge=4 pointers exist only under DOS");
		this.addQuestion(q7,s);
		
		Question q8=new Question("Which of the following cannot be checked in a switch-case statement?","Character","enum","Float","C","Float and double are not allowed.");
		this.addQuestion(q8,s);
		
		Question q9=new Question("Which of the declaration is correct?","int length;","float double;","int long;","A","int length; denotes that variable length is int(integer) data type.");
		this.addQuestion(q9,s);
		Question q10=new Question("correct order of evaluation? z = x + y * z / 4 % 2 - 1","/ * % - + =","= * / % + -","* / % + - =","C","C uses left associativity for evaluating expressions to break a tie between two operators having same precedence.");
		this.addQuestion(q10,s);
		
		Question q11=new Question("In which header file is the NULL macro defined?","stdio.h","stddef.h","stdio.h and stddef.h","C","The macro \"NULL\" is defined in locale.h, stddef.h, stdio.h, stdlib.h, string.h, time.h, and wchar.h.");
		this.addQuestion(q11,s);

		Question q12=new Question("Which statement obtains the remainder on dividing 5.5 by 1.3 ?","rem = (5.5 % 1.3)","rem = fmod(5.5, 1.3)","Error: we can't divide","B","rem = fmod(5.5, 1.3");
		this.addQuestion(q12,s);

		Question q13=new Question("If a variable is a pointer to a structure, then which of the following operator is used to access data members of the structure through the pointer variable?",".","&","->","C"," Members are accessed using -> operator");
		this.addQuestion(q13,s);


		Question q14=new Question("The operator used to get value at address stored in a pointer variable is","*","&","&&","A"," * is used to get the value stored at an address");
		this.addQuestion(q14,s);

		Question q15=new Question("How will you free the allocated memory? ","remove(var-name);","free(var-name);","delete(var-name);","B","The inbuilt function free() is used");
		this.addQuestion(q15,s);

		Question q16=new Question("What is the similarity between a structure, union and enumeration?","All of them let you define new values","All of them let you define new data types","All of them let you define new pointers","B","All are used to create user defined data types");
		this.addQuestion(q16,s);

		Question q17=new Question("What does the following declaration mean?int (*ptr)[10];","ptr is array of pointers to 10 integers","ptr is a pointer to an array of 10 integers","ptr is an array of 10 integers","B","Here ptr points to an array !! It is not an array by itself");
		this.addQuestion(q17,s);

		Question q18=new Question("In C, if you pass an array as an argument to a function, what actually gets passed?","Value of elements in array","First element of the array ","Base address of the array","C","The statement 'C' is correct. When we pass an array as a funtion argument, the base address of the array will be passed.");
		this.addQuestion(q18,s);

		Question q19=new Question("What will you do to treat the constant 3.14 as a float?","use float(3.14f)","use 3.14f","use f(3.14)","B","To specify 3.14 as float, we have to add f to the 3.14. (i.e 3.14f)");
		this.addQuestion(q19,s);

		Question q20=new Question("	In which stage the following code \n#include<stdio.h>\ngets replaced by the contents of the file stdio.h","During editing","During linking","During preprocessing","C","That is why it is called header file");
		this.addQuestion(q20,s);
		
	}
	public void addQuestions2()
	{
		String s="Probability";
			Question q1=new Question("Tickets numbered 1 to 20 are mixed up and then a ticket is drawn at random. What is the probability that the ticket drawn has a number which is a multiple of 3 or 5?","1/2","2/5","9/20","C"," Here, S = {1, 2, 3, 4, ...., 19, 20}.\nLet E = event of getting a multiple of 3 or 5 = {3, 6 , 9, 12, 15, 18, 5, 10, 20}.\nP(E)=n(E)=9.\nn(S)=20");
				this.addQuestion(q1,s);

				Question q2=new Question("A bag contains 2 red, 3 green and 2 blue balls. Two balls are drawn at random. What is the probability that none of the balls drawn is blue?","10/21","21/50","9/20","A"," Total number of balls = (2 + 3 + 2) = 7.\nLet S be the sample space.\nThen, n(S)= Number of ways of drawing 2 balls out of 7=21\nLet E = Event of drawing 2 balls, none of which is blue.\nn(E)= Number of ways of drawing 2 balls out of (2 + 3) balls=10");
				this.addQuestion(q2,s);

				Question q3=new Question("In a box, there are 8 red, 7 blue and 6 green balls. One ball is picked up randomly. What is the probability that it is neither red nor green?","1/3","3/4","2/7","A"," Total number of balls = (8 + 7 + 6) = 21.\nLet E= event that the ball drawn is neither red nor green= event that the ball drawn is blue.=7\nn(s)=21\nP(E)=7/21");
				this.addQuestion(q3,s);


				Question q4=new Question("What is the probability of getting a sum 9 from two throws of a dice?","1/6","1/8","1/9","C"," In two throws of a die, n(S) = (6 x 6) = 36.\nLet E = event of getting a sum ={(3, 6), (4, 5), (5, 4), (6, 3)}.");
				this.addQuestion(q4,s);


				Question q5=new Question("Three unbiased coins are tossed. What is the probability of getting atmost two heads ? " ,"3/4","1/4","7/8","C","Here S = {TTT, TTH, THT, HTT, THH, HTH, HHT, HHH}\nLet E = event of getting at most two heads.\nThen E = {TTT, TTH, THT, HTT, THH, HTH, HHT}.");
				this.addQuestion(q5,s);

				Question q6=new Question("Two dice are thrown simultaneously. What is the probability of getting two numbers whose product is even?" ,"1/2","3/4","3/8","B","In a simultaneous throw of two dice, we have n(S) = (6 x 6) = 36.\nThen, E	= {(1, 2), (1, 4), (1, 6), (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (3, 2), (3, 4),\n(3, 6), (4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (5, 2), (5, 4), (5, 6), (6, 1),\n(6, 2), (6, 3), (6, 4), (6, 5), (6, 6)}\n n(E) = 27.\n P(E)=27/36");
				this.addQuestion(q6,s);

				Question q7=new Question("In a class, there are 15 boys and 10 girls. Three students are selected at random. The probability that 1 girl and 2 boys are selected, is:" ,"21/46","25/117","3/8","A","Let S be the sample space and E be the event of selecting 1 girl and 2 boys.\nThen, n(S)= Number ways of selecting 3 students out of 25=2300\nn(E)=1050\nP(E)=1050/2300");
				this.addQuestion(q7,s);


				Question q8=new Question("In a lottery, there are 10 prizes and 25 blanks. A lottery is drawn at random. What is the probability of getting a prize?" ,"1/10","2/5","2/7","C","P (getting a prize) =10/35");
				this.addQuestion(q8,s);


				Question q9=new Question("Two dice are tossed. The probability that the total score is a prime number is:" ,"1/6","5/12","1/2","B","Clearly, n(S) = (6 x 6) = 36.\nLet E = Event that the sum is a prime number.\nThen E	= { (1, 1), (1, 2), (1, 4), (1, 6), (2, 1), (2, 3), (2, 5), (3, 2), (3, 4), (4, 1), (4, 3),\n (5, 2), (5, 6), (6, 1), (6, 5) }\n n(E) = 15.\n P(E)=15/36");
				this.addQuestion(q9,s);


				Question q10=new Question("One card is drawn at random from a pack of 52 cards. What is the probability that the card drawn is a face card (Jack, Queen and King only)?","1/13","3/13","1/2","B","Clearly there are 52 cards, out of which there are 12 face cards.\nP(E)=12/52");
				this.addQuestion(q10,s);
	}
	public void addQuestions3()
	{
		String s="POT";
		Question q1=new Question("A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?","120 metres","180 metres","150 metres","C"," speed=(60*(5/18)=(50/3)m/sec\nLength=(50/3*9)=150m");
				this.addQuestion(q1,s);

				Question q2=new Question("A train passes a station platform in 36 seconds and a man standing on the platform in 20 seconds. If the speed of the train is 54 km/hr, what is the length of the platform?","120 metres","240 metres","300 metres","B"," speed=(54*(5/18)=15m/sec\nLength of train=(15*20)=300m\nlength of platform + 300=540\nlength of platform = 240");
				this.addQuestion(q2,s);

				Question q3=new Question("A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:","50 kmph","45 kmph","54 kmph","A","\nSpeed of the train relative to man = (125/10) m/sec\nLet the speed of the train be x km/hr. Then, relative speed = (x - 5) km/hr.\n x - 5 = 45 \n x = 50 km/hr.");
				this.addQuestion(q3,s);

				Question q4=new Question("The length of the bridge, which a train 130 metres long and travelling at 45 km/hr can cross in 30 seconds, is:","225 m","200 m","245 m","C","Speed =(25/2) m/sec\nTime=30s\nLet the length of bridge be x metres.\n 2(130 + x) = 750\n  x = 245 m.");
				this.addQuestion(q4,s);


				Question q5=new Question("Two, trains, one from Howrah to Patna and the other from Patna to Howrah, start simultaneously. After they meet, the trains reach their destinations after 9 hours and 16 hours respectively. The ratio of their speeds is:","2:3","4:3","6:7","B","Let us name the trains as A and B. Then, (A's speed) : (B's speed) = b : a = 16 : 9 = 4 : 3.");
				this.addQuestion(q5,s);

				Question q6=new Question("Two trains running in opposite directions cross a man standing on the platform in 27 seconds and 17 seconds respectively and they cross each other in 23 seconds. The ratio of their speeds is:","1:3","3:2","3:4","B","Let the speeds of the two trains be x m/sec and y m/sec respectively.\nThen, length of the first train = 27x metres,\n	and length of the second train = 17y metres.\n	27x + 17y = 23x + 23y\n	4x = 6y");
				this.addQuestion(q6,s);

				Question q7=new Question("A train 800 metres long is running at a speed of 78 km/hr. If it crosses a tunnel in 1 minute, then the length of the tunnel (in meters) is:","130","360","500","C","Speed=(65/3) m/s\nTime = 1 minute = 60 seconds.\nLet the length of the tunnel be x metres.\n	 3(800 + x) = 3900\n	 x = 500.");
				this.addQuestion(q7,s);

				Question q8=new Question("A 300 metre long train crosses a platform in 39 seconds while it crosses a signal pole in 18 seconds. What is the length of the platform?","320 m","350 m","650 m","B","Let the length of the platform be x metres.\n3(x + 300) = 1950\n	x = 350 m.");
				this.addQuestion(q8,s);

				Question q9=new Question("A train speeds past a pole in 15 seconds and a platform 100 m long in 25 seconds. Its length is: ","50","150","200","B","Let the length of the train be x metres and its speed by y m/sec.\n	15(x + 100) = 25x\n	15x + 1500 = 25x\n	1500 = 10x\n	x = 150 m.");
				this.addQuestion(q9,s);

				Question q10=new Question("How many seconds will a 500 metre long train take to cross a man walking with a speed of 3 km/hr in the direction of the moving train if the speed of the train is 63 km/hr?","25","30","40","B","Speed of the train relative to man	= (63 - 3) km/hr\n	= 60 km/hr\n	Time taken to pass the man=30 sec");
				this.addQuestion(q10,s);
	}
	public void addQuestions4()
	{
		String s="TAW";
		Question q1=new Question("A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is :","1/4","1/10","8/15","C","(A+B)'s 1 day's work=7/60 . (A+B)'s 4 day's work=7/15. Therfore remaining work=1-7/15=8/15");
		this.addQuestion(q1,s);

		Question q2=new Question("A can lay railway track between two given stations in 16 days and B can do the same job in 12 days. With help of C, they did the job in 4 days only. Then, C alone can do the job in:","9 1/5","9 2/5","9 3/5","C","(A+B+C)'s 1 day's work=1/4 . C's 1 day work=1/4-(1/16+1/12)=5/48\nSo,C can do the work in 9 3/5 days");
		this.addQuestion(q2,s);


		Question q3=new Question("A, B and C can do a piece of work in 20, 30 and 60 days respectively. In how many days can A do the work if he is assisted by B and C on every third day?","12 days","15 days","18 days","B","Now, 1/5 work is done in 3 days.\nWhole work will be done in (3 x 5) = 15 days.");
		this.addQuestion(q3,s);


		Question q4=new Question("A and B together can do a piece of work in 30 days. A having worked for 16 days, B finishes the remaining work alone in 44 days. In how many days shall B finish the whole work alone?","30 days","40 days","60 days","C","Let A's 1 day's work = x and B's 1 day's work = y.\nThen x+y=1/30 and 16x+44y=1\nso x,y=1/60");
		this.addQuestion(q4,s);

		Question q5=new Question("A and B can do a work in 8 days, B and C can do the same work in 12 days. A, B and C together can finish it in 6 days. A and C together will do it in :","4 days","6 days","8 days","C","(A+B+C)=1/6\n(A+B)=1/8\n(B+C)=1/12\n(A+C)=(1/3-(1/8+1/12))=1/8");
		this.addQuestion(q5,s);


		Question q6=new Question("A takes twice as much time as B or thrice as much time as C to finish a piece of work. Working together, they can finish the work in 2 days. B can do the work alone in:","4 days","6 days","8 days","B","B takes 6 days to finish the work");
		this.addQuestion(q6,s);

		Question q7=new Question("Twenty women can do a work in sixteen days. Sixteen men can complete the same work in fifteen days. What is the ratio between the capacity of a man and a woman?","3:4","4:3","5:3","B","1 woman's 1 day work=1/320\n1 man's 1 day work=1/240");
		this.addQuestion(q7,s);

		Question q8=new Question("Sakshi can do a piece of work in 20 days. Tanya is 25% more efficient than Sakshi. The number of days taken by Tanya to do the same piece of work is:","15","16","18","B","Ratio of times taken by Sakshi and Tanya is 5:4\nso x=(4*20)/5\nx=16 days");
		this.addQuestion(q8,s);

		Question q9=new Question("A can finish a work in 18 days and B can do the same work in 15 days. B worked for 10 days and left the job. In how many days, A alone can finish the remaining work?","5","5 1/2","6","C","B's 10 days's work=2/3\nremaining work=1-2/3=1/3\n1/18 work is done by A in 1 day\nso 1/3 work is done in 6 days");
		this.addQuestion(q9,s);


		Question q10=new Question("10 women can complete a work in 7 days and 10 children take 14 days to complete the work. How many days will 5 women and 10 children take to complete the work?","3","5","7","C","1 woman's 1 day work=1/70\n1 child's 1 day work=1/140\nso 5 women and 10 children complete work in 7 days");
		this.addQuestion(q10,s);
		
	}
	
	public void addQuestion(Question quest,String TABLE_NAME) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_SOL, quest.getSOL());
		// Inserting Row
		dbase.insert(TABLE_NAME, null, values);
		}

	public List<Question> getAllQuestions(String tname) {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + tname;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
		do {
		Question quest = new Question();
		quest.setID(cursor.getInt(0));
		quest.setQUESTION(cursor.getString(1));
		quest.setANSWER(cursor.getString(2));
		quest.setOPTA(cursor.getString(3));
		quest.setOPTB(cursor.getString(4));
		quest.setOPTC(cursor.getString(5));
		quest.setSOL(cursor.getString(6));
		quesList.add(quest);
		} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
		}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
		// Create tables again
		onCreate(db);
	}
	
	

}
