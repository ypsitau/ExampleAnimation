package io.github.ypsitau.exampleanimation;

import android.animation.LayoutTransition;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
	ConstraintLayout layout;
	ImageButton imageButton_toggle1;
	ImageButton imageButton_toggle2;
	ImageButton imageButton_toggle3;
	ViewGroup viewGroup1;
	ViewGroup viewGroup2;
	ViewGroup viewGroup3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = findViewById(R.id.layout);
		imageButton_toggle1 = findViewById(R.id.imageButton_toggle1);
		imageButton_toggle2 = findViewById(R.id.imageButton_toggle2);
		imageButton_toggle3 = findViewById(R.id.imageButton_toggle3);
		viewGroup1 = findViewById(R.id.viewGroup1);
		viewGroup2 = findViewById(R.id.viewGroup2);
		viewGroup3 = findViewById(R.id.viewGroup3);
		LayoutTransition layoutTransition = new LayoutTransition();
		//layoutTransition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0);
		//layoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING, 1000);
		//layoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, 10);
		layout.setLayoutTransition(layoutTransition);
		imageButton_toggle1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisilibity(imageButton_toggle1, viewGroup1);
			}
		});
		imageButton_toggle2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisilibity(imageButton_toggle2, viewGroup2);
			}
		});
		imageButton_toggle3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisilibity(imageButton_toggle3, viewGroup3);
			}
		});
	}
	private static void toggleVisilibity(ImageButton imageButton_toggle, ViewGroup viewGroup) {
		int visibility = viewGroup.getVisibility();
		if (visibility == View.VISIBLE) {
			imageButton_toggle.setImageResource(android.R.drawable.ic_input_add);
			viewGroup.setVisibility(View.GONE);
		} else { // visibility == View.GONE
			imageButton_toggle.setImageResource(android.R.drawable.ic_delete);
			viewGroup.setVisibility(View.VISIBLE);
		}
	}
}
