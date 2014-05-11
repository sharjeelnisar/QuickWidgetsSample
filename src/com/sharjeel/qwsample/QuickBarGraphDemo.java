package com.sharjeel.qwsample;

import com.sharjeel.quickwidgets.QuickBarGraph;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

public class QuickBarGraphDemo extends Activity {

	private static int[] data = {23,40,56,30,27,100,75};
	private static String[] xLabels = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	
	private RelativeLayout rLoutQuickBarGraph;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_bar_graph_demo);
		context = this;
		initializeViews();
		displayQuickBarGraph();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quick_bar_graph_demo, menu);
		return true;
	}

	public void initializeViews(){
		rLoutQuickBarGraph = (RelativeLayout)findViewById(R.id.rLoutQuickBarGraph);
	}
	
	public void displayQuickBarGraph(){
		 int barWidth = 60;
  		int barStartingPoint = 30;
  		int barSpacing = 110;
  		int graphWidth = barWidth + 20;
  		int graphHeight = 320;
		RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[data.length] ;
		QuickBarGraph[] qBarGraphs = new QuickBarGraph[data.length];
		
	  for(int counter = 0; counter < data.length; counter++){
		    qBarGraphs[counter] = new QuickBarGraph(context,"ARIAL.TTF","ARIAL.TTF","ARIAL.TTF");
		    params[counter] = new RelativeLayout.LayoutParams(graphWidth,graphHeight);
			params[counter].addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			 if(counter == 0){
 				 params[counter].setMargins(barStartingPoint, 0, 0, 0);
 			  }else{
 			      params[counter].setMargins(barStartingPoint + barSpacing * counter, 0, 0, 0);
 			       }
			 qBarGraphs[counter].setxLabel(xLabels[counter]);
			 qBarGraphs[counter].setxLabelTextSize(14);
			 qBarGraphs[counter].setxLabelXCoordinate(15);
			 qBarGraphs[counter].setxLabelYCoordinate(250);
			 qBarGraphs[counter].setxLabelColor("#00aeef");
			 qBarGraphs[counter].setBarHeight(data[counter]);
			 qBarGraphs[counter].setBarWidth(50);
			 qBarGraphs[counter].setBarXCoordinate(0);
			 qBarGraphs[counter].setBarYCoordinate(220-data[counter]);
			qBarGraphs[counter].setyLabel(String.valueOf(data[counter]));
			qBarGraphs[counter].setyLabelTextSize(14);
			qBarGraphs[counter].setyLabelXCoordinate(15);
			qBarGraphs[counter].setyLabelYCoordinate(210-data[counter]);
			qBarGraphs[counter].setyLabelColor("#00aeef");
			rLoutQuickBarGraph.addView(qBarGraphs[counter],params[counter]);
			
	  }

}

}
