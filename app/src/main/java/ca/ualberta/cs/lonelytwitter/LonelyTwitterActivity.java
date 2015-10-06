package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver, MyObservable {

	private static final String FILENAME = "file.sav";//method
	private EditText bodyText;//view
	private ListView oldTweetsList;//controller
	private ArrayList<Tweet> tweets;//controller
	private ArrayAdapter<Tweet> adapter;//view

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {//view

		super.onCreate(savedInstanceState);//view
		setContentView(R.layout.main);//view

		bodyText = (EditText) findViewById(R.id.body);//view
		Button saveButton = (Button) findViewById(R.id.save);//view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);//view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {//view
				setResult(RESULT_OK);//view
				String text = bodyText.getText().toString();//controller
				tweets.add(new NormalTweet(text));//controller
				saveInFile();//method
				adapter.notifyDataSetChanged();//view

				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();//method
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);//view
		oldTweetsList.setAdapter(adapter);//view
	}

	private void loadFromFile() {//method
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);//method
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));//method
			Gson gson = new Gson();//metod
			//Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();//method
			tweets = gson.fromJson(in,listType);//method

			/*String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			old non Gson method to read strings from file
			}*/

		} catch (FileNotFoundException e) {//method
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();//method
		} catch (IOException e) {//method
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//method
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {//method
		try {//method
			FileOutputStream fos = openFileOutput(FILENAME,//method
					0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);//method
			Gson gson = new Gson();//method
			gson.toJson(tweets, writer);//method
			writer.flush();//method
			//fos.write(new String(date.toString() + " | " + text)
			//		.getBytes());
			fos.close();//method
		} catch (FileNotFoundException e) {//method
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//method
		} catch (IOException e) {//method
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//method
		}
	}

	public void myNotify(MyObservable observable){
		adapter.notifyDataSetChanged();//view
	}

	public void addObserver(MyObserver observer){

	}


}