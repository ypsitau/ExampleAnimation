package io.github.ypsitau.exampleanimation;

import android.animation.LayoutTransition;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
	private ConstraintLayout layout;
	private ImageButton imageButton_toggle1;
	private ImageButton imageButton_toggle2;
	private ImageButton imageButton_toggle3;
	private ViewGroup viewGroup1;
	private ViewGroup viewGroup2;
	private ViewGroup viewGroup3;
	private EditText editText_log;
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
		editText_log = findViewById(R.id.editText_log);
		LayoutTransition layoutTransition = new LayoutTransition();
		//layoutTransition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0);
		//layoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING, 1000);
		//layoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, 10);
		layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
			@Override
			public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
				printf("startTransition(%s)\n", transitionTypeToName(transitionType));
			}

			@Override
			public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
				printf("endTransition(%s)\n", transitionTypeToName(transitionType));
			}
		});
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

	private void toggleVisilibity(ImageButton imageButton_toggle, ViewGroup viewGroup) {
		printf("----\n");
		int visibility = viewGroup.getVisibility();
		if (visibility == View.VISIBLE) {
			imageButton_toggle.setImageResource(android.R.drawable.ic_input_add);
			viewGroup.setVisibility(View.GONE);
		} else { // visibility == View.GONE
			imageButton_toggle.setImageResource(android.R.drawable.ic_delete);
			viewGroup.setVisibility(View.VISIBLE);
		}
	}

	public void printf(String format, Object... args) {
		editText_log.append(String.format(format, args));
		editText_log.setSelection(editText_log.getText().length());
	}

	static final Map<Integer, String> mapTransitionTypeToName = new HashMap<Integer, String>() {{
		put(LayoutTransition.CHANGE_APPEARING, "CHANGE_APPEARING");
		put(LayoutTransition.CHANGE_DISAPPEARING, "CHANGE_DIAPPEARING");
		put(LayoutTransition.APPEARING, "APPEARING");
		put(LayoutTransition.DISAPPEARING, "DISAPPEARING");
		put(LayoutTransition.CHANGING, "CHANGING");
	}};

	static public String transitionTypeToName(int transitionType) {
		return mapTransitionTypeToName.get(transitionType);
	}
}
