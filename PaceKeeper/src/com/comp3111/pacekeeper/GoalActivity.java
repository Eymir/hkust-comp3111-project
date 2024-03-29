package com.comp3111.pacekeeper;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class GoalActivity extends Activity implements OnClickListener{
	
	private static String timeTitle = "Time Goal";
	private static String stepTitle = "Step Goal";
	private static String distanceTitle = "Distance Goal";
	private static String cardioTitle = "Cardio Goal";
	private static String[] timeSelection = new String[] { "10 minutes", "20 minutes", "30 minutes", "1 hour", "1.5 hours", "2 hours" };
	private static String[] stepSelection = new String[] { "1000 steps", "2000 steps", "5000 steps", "10000 steps", "20000 steps", "50000 steps" };
	private static String[] distanceSelection = new String[] { "500 miles", "1000 miles", "2000 miles", "5000 miles", "10000 miles", "20000 miles" };
	

	// abundant for later use
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goal);
		findViewById(R.id.goal_time).setOnClickListener(this);
		findViewById(R.id.goal_dist).setOnClickListener(this);
		findViewById(R.id.goal_step).setOnClickListener(this);
		findViewById(R.id.goal_cardio).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		int goalId = -1;
		String title = null;
		String[] selection = null;
		
		// TODO Case switch of buttons
		switch(arg0.getId()){
		case	R.id.goal_time:
			goalId = 0;
			title = timeTitle;
			selection = timeSelection;
			break;
		case	R.id.goal_step:
			goalId = 1;
			title = stepTitle;
			selection = stepSelection;
			break;
		case	R.id.goal_dist:
			goalId = 2;
			title = distanceTitle;
			selection = distanceSelection;
			break;
		case	R.id.goal_cardio:
			goalId = 3;
			title = cardioTitle;
			selection = timeSelection;
		}

		// building spinner for selection
		new AlertDialog.Builder(this).setTitle(title)
									 .setItems(selection, new GoalSelectionListener(goalId, title))
									 .setNegativeButton("Cancel", null)
									 .show();
	}
	
	class GoalSelectionListener implements android.content.DialogInterface.OnClickListener{
		private int goalId;
		private String goalType;

		public GoalSelectionListener(int goalId, String goalType) {
			// TODO Auto-generated constructor stub
			this.goalId = goalId;
			this.goalType = goalType;
		}
		
		// goal_type = title when passing to MusicActivity intent
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(GoalActivity.this, MusicActivity.class);
			intent.putExtra("goal_type", goalType);
			GoalActivity.this.startActivity(intent);
			GoalActivity.this.finish();
		}
	}

}
