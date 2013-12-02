package br.com.confraria.beerbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BeerInfoActivity extends Activity {

	public static final String EXTRA_BEER_NAME = "beerbuddy.EXTRA_BEER_NAME";
	public static final String ACTION_FIND_BEER = "beerbuddy.ACTION_FIND_BEER";
	public static final String CATEGORY_FIND_BEER = "beerbuddy.CATEGORY_FIND_BEER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beer_info);

		TextView resultadoPesquisa = (TextView) findViewById(R.id.resultadoPesquisa);
		Intent intent = getIntent();
		if (intent.hasExtra(EXTRA_BEER_NAME)) {
			resultadoPesquisa.setText("RESULTADO PESQUISA CERVEJA: "+ intent.getExtras().getString(EXTRA_BEER_NAME));
		} else {
			resultadoPesquisa.setText("O nome da cerveja n~ao foi informado");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.beer_info, menu);
		return true;
	}

}
