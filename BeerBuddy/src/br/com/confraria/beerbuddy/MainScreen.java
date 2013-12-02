package br.com.confraria.beerbuddy;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainScreen extends Activity {
	private EditText txPesquisa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_screen);
		//Form sets
		txPesquisa = (EditText)findViewById(R.id.txPesquisa);

		ListView feedList = (ListView) findViewById(R.id.list);
		feedList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listarNewsFeed()));
	}

	private List<String> listarNewsFeed() {
		return Arrays.asList("Marcio degustou a cerveja X",
				"Yuri sugeriu a cerveja Y", "Andre sugeriu a cerveja Z");
	}
	
	public void realizarPesquisa(View view){
		Intent intentSearch = new Intent(BeerInfoActivity.ACTION_FIND_BEER);
		intentSearch.addCategory(BeerInfoActivity.CATEGORY_FIND_BEER);
		String valorPesquisado = txPesquisa.getText().toString();
		intentSearch.putExtra(BeerInfoActivity.EXTRA_BEER_NAME, valorPesquisado);
		startActivity(intentSearch);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
