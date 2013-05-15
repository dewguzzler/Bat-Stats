package com.gorecki.batstats;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class BatStatsActivity extends Activity {

	public static int atBatsCounter = 0, hitsCounter = 0, singlesCounter = 0,
			doublesCounter = 0, triplesCounter = 0, homerunsCounter = 0,
			walksCounter = 0, hbpCounter = 0, rbiCounter = 0, runCounter = 0,
			strikeoutCounter = 0, groundoutCounter = 0, flyoutCounter = 0,
			lineoutCounter = 0, sacbuntCounter = 0, sacflyCounter = 0,
			stolenbaseCounter = 0, caughtstealingCounter = 0,
			reachedonerrorCounter = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		final TextView atbatsnum = (TextView) findViewById(R.id.atbatsnum);
		final TextView averagenum = (TextView) findViewById(R.id.averagenum);
		final TextView hitsnum = (TextView) findViewById(R.id.hitsnum);
		final TextView singlesnum = (TextView) findViewById(R.id.singlesnum);
		final TextView doublesnum = (TextView) findViewById(R.id.doublesnum);
		final TextView triplesnum = (TextView) findViewById(R.id.triplesnum);
		final TextView homerunsnum = (TextView) findViewById(R.id.homerunsnum);
		final TextView walksnum = (TextView) findViewById(R.id.walksnum);
		final TextView hbpnum = (TextView) findViewById(R.id.hbpnum);
		final TextView rbisnum = (TextView) findViewById(R.id.rbinum);
		final TextView obpnum = (TextView) findViewById(R.id.obpnum);
		final TextView runsnum = (TextView) findViewById(R.id.runsnum);
		final TextView strikeoutsnum = (TextView) findViewById(R.id.strikeoutsnum);
		final TextView groundoutsnum = (TextView) findViewById(R.id.groundoutnum);
		final TextView flyoutsnum = (TextView) findViewById(R.id.flyoutsnum);
		final TextView lineoutsnum = (TextView) findViewById(R.id.lineoutsnum);
		final TextView sacbuntsnum = (TextView) findViewById(R.id.sacbuntsnum);
		final TextView sacfliesnum = (TextView) findViewById(R.id.sacfliesnum);
		final TextView stolenbasenum = (TextView) findViewById(R.id.stolenbasesnum);
		final TextView caughtstealingnum = (TextView) findViewById(R.id.caughtstealingnum);
		final TextView stolenbasepercentnum = (TextView) findViewById(R.id.stolenbasepercentnum);
		final TextView reachedonerrornum = (TextView) findViewById(R.id.reachedonerrornum);
		final TextView sluggingpercentnum = (TextView) findViewById(R.id.sluggingpercentnum);

		final CharSequence[] statItems = { "Single", "Double", "Triple",
				"Homerun", "Reach on Error", "Strike Out", "Fly Out",
				"Ground Out", "Line Out", "Sac Bunt", "Sac Fly", "Walk",
				"Stolen Base", "Caught Stealing", "Hit By Pitch", "RBI",
				"Fielders Choice", "Run Scored" };

		switch (item.getItemId()) {
		case R.id.addStatistic:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Add A Statistic");

			builder.setItems(statItems, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {

					switch (item) {
					// single
					case 0:
						++atBatsCounter;
						++hitsCounter;
						++singlesCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						hitsnum.setText(Integer.toString(hitsCounter));
						singlesnum.setText(Integer.toString(singlesCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// double
					case 1:
						++atBatsCounter;
						++hitsCounter;
						++doublesCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						hitsnum.setText(Integer.toString(hitsCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						doublesnum.setText(Integer.toString(doublesCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// triple
					case 2:
						++atBatsCounter;
						++hitsCounter;
						++triplesCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						hitsnum.setText(Integer.toString(hitsCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						triplesnum.setText(Integer.toString(triplesCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// homerun
					case 3:
						++atBatsCounter;
						++hitsCounter;
						++homerunsCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						hitsnum.setText(Integer.toString(hitsCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						homerunsnum.setText(Integer.toString(homerunsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// ROE
					case 4:
						++atBatsCounter;
						++reachedonerrorCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						reachedonerrornum.setText(Integer
								.toString(reachedonerrorCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// strikeout
					case 5:
						++atBatsCounter;
						++strikeoutCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						strikeoutsnum.setText(Integer
								.toString(strikeoutCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// flyout
					case 6:
						++atBatsCounter;
						++flyoutCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						flyoutsnum.setText(Integer.toString(flyoutCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// ground out
					case 7:
						++atBatsCounter;
						++groundoutCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						groundoutsnum.setText(Integer
								.toString(groundoutCounter));
						averagenum.setText(Integer.toString(hitsCounter
								/ atBatsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// lineout
					case 8:
						++atBatsCounter;
						++lineoutCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						lineoutsnum.setText(Integer.toString(lineoutCounter));
						averagenum.setText(Integer.toString((hitsCounter)
								/ atBatsCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						sluggingpercentnum.setText(Integer
								.toString((singlesCounter
										+ (2 * doublesCounter)
										+ (3 * triplesCounter) + (4 * homerunsCounter)
										/ atBatsCounter))
								+ "%");
						break;

					// sac bunt
					case 9:
						++sacbuntCounter;
						sacbuntsnum.setText(Integer.toString(sacbuntCounter));
						break;

					// sac fly
					case 10:
						++sacflyCounter;
						sacfliesnum.setText(Integer.toString(sacflyCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						break;

					// walk
					case 11:
						++walksCounter;
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");
						walksnum.setText(Integer.toString(walksCounter));
						break;

					// stolen base
					case 12:
						++stolenbaseCounter;
						stolenbasenum.setText(Integer
								.toString(stolenbaseCounter));
						stolenbasepercentnum.setText(Integer
								.toString(stolenbaseCounter
										/ (stolenbaseCounter + caughtstealingCounter)));
						break;

					// caught stealing
					case 13:
						++caughtstealingCounter;
						caughtstealingnum.setText(Integer
								.toString(caughtstealingCounter));
						stolenbasepercentnum.setText(Integer
								.toString(stolenbaseCounter
										/ (stolenbaseCounter + caughtstealingCounter)));
						break;

					// HBP
					case 14:
						++hbpCounter;
						hbpnum.setText(Integer.toString(hbpCounter));
						obpnum.setText(Integer
								.toString((hitsCounter + walksCounter + hbpCounter)
										/ (atBatsCounter + walksCounter
												+ hbpCounter + sacflyCounter))
								+ "%");

						break;
					// RBI
					case 15:
						++rbiCounter;
						rbisnum.setText(Integer.toString(rbiCounter));
						break;

					// fielders choice
					case 16:
						++atBatsCounter;
						atbatsnum.setText(Integer.toString(atBatsCounter));
						break;

					// run scored
					case 17:
						++runCounter;
						runsnum.setText(Integer.toString(runCounter));
						break;

					}

				}

			});

			AlertDialog alert = builder.create();
			alert.show();

			return true;
		default:
			return false;

		}

	}
}