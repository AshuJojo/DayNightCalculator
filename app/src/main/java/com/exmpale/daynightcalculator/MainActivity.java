package com.exmpale.daynightcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mValue1, mValue2, mResult, mSymbol1, mSymbol2;
    private View dashedLine;
    private double Num1, Num2;
    private boolean mAdd, mSub, mMult, mDiv, mPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialization of buttons
        Button button0 = findViewById(R.id.button_0);
        Button button00 = findViewById(R.id.button_00);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button_equals = findViewById(R.id.button_equals);
        Button button_percentage = findViewById(R.id.button_percentage);
        Button button_add = findViewById(R.id.button_add);
        Button button_sub = findViewById(R.id.button_sub);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_point = findViewById(R.id.button_point);
        Button button_clear = findViewById(R.id.button_ac);
        //Initialization of ImageButton
        ImageButton button_backspace = findViewById(R.id.imageButton_backspace);
        //Initialization of textViews
        mResult = findViewById(R.id.result);
        mValue1 = findViewById(R.id.value1);
        mValue2 = findViewById(R.id.value2);
        mSymbol1 = findViewById(R.id.symbol1);
        mSymbol2 = findViewById(R.id.symbol2);
        //Initialization of dashedLine view
        dashedLine = findViewById(R.id.dashedLine);

        //Setting onClickListeners for buttons
        button0.setOnClickListener(this);
        button00.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_percentage.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_backspace.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem itemSwitch = menu.findItem(R.id.menu_switch);
        itemSwitch.setActionView(R.layout.menu_switch);
        final Switch sw = menu.findItem(R.id.menu_switch).getActionView().findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    /*
     * onClickListeners for buttons
     */
    @Override
    public void onClick(View v) {
        //switch/case statement to get the id of the button
        //and then perform the corresponding event
        switch (v.getId()) {
            case R.id.button_0:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_0));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_0));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_0));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_0));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_00:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_0));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_00));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_0));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_00));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_1:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_1));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_1));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_1));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_1));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_2:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_2));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_2));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_2));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_2));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_3:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_3));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_3));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_3));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_3));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_4:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_4));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_4));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_4));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_4));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_5:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_5));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_5));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_5));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_5));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_6:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_6));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_6));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_6));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_6));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_7:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_7));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_7));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_7));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_7));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_8:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_8));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_8));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_8));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_8));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_9:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (!mValue1.getText().toString().matches("")) {
                        Num1 = Double.parseDouble(mValue2.getText() + "");
                        if (Num1 == 0 || !mResult.getText().toString().matches("")) {
                            if (mResult.getText().toString().matches("")
                                    && !mValue1.getText().toString().matches("")
                                    && !mSymbol2.getText().toString().matches("")) {
                                mValue1.setText(mValue1.getText());
                                mSymbol2.setText(mSymbol2.getText());
                            } else {
                                mValue1.setText("");
                                mSymbol2.setText("");
                            }
                            mValue2.setText(getString(R.string.button_9));
                            mResult.setText("");
                            mSymbol1.setText("");
                            dashedLine.setVisibility(View.INVISIBLE);
                            mPercent = false;
                        } else {
                            mValue2.setText(mValue2.getText() + getString(R.string.button_9));
                        }
                    } else {
                        mValue2.setText(getString(R.string.button_9));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    mValue2.setText(mValue2.getText() + getString(R.string.button_9));
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_point:
                if (!mValue2.getText().toString().matches("")) {
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                } else {
                    mValue2.setText("");
                }
                if (Num1 == 0 && !mValue2.getText().toString().contains(".")
                        || mPercent || !mResult.getText().toString().matches("")) {
                    if (mResult.getText().toString().matches("")) {
                        mValue2.setText(getString(R.string.point_text));
                        mResult.setText("");
                        mValue1.setText(mValue1.getText());
                        mSymbol1.setText(mSymbol1.getText());
                        mSymbol2.setText(mSymbol2.getText());
                        dashedLine.setVisibility(View.INVISIBLE);
                    } else {
                        mValue2.setText(getString(R.string.point_text));
                        mResult.setText("");
                        mValue1.setText("");
                        mSymbol1.setText("");
                        mSymbol2.setText("");
                        dashedLine.setVisibility(View.INVISIBLE);
                        mPercent = false;
                    }
                } else {
                    if (mValue2.getText().toString().contains(".")) {
                        mValue2.setText(mValue2.getText());
                    } else {
                        mValue2.setText(mValue2.getText() + getString(R.string.button_point));
                    }
                }
                mValue2.setVisibility(View.VISIBLE);
                break;
            case R.id.button_ac:
                //button to remove every text from the textViews and
                //setting the value2 text 0
                mResult.setText("");
                mValue2.setText(getString(R.string.value2_text));
                mValue1.setText("");
                mSymbol1.setText("");
                mSymbol2.setText("");
                //setting dashedLine visibility to be invisible
                dashedLine.setVisibility(View.INVISIBLE);
                break;
            case R.id.imageButton_backspace:
                if (mResult.getText().toString().matches("")
                        && !mValue2.getText().toString().matches("")) {
                    //if else statement for determining whether the
                    //value2 textView is empty or not
                    if (mValue2.getText().toString().length() == 1) {
                        mValue2.setText("");
                    } else {
                        mValue2.setText(mValue2.getText().toString().substring
                                (0, mValue2.getText().toString().length() - 1));
                    }

                } else {
                    //Do Nothing
                }
                break;
            case R.id.button_add:
                if(mValue1.getText().toString().matches("")){
                    //setting the value1 textView's text from value2 textView
                    mValue1.setText(mValue2.getText().toString());
                    //setting the symbol2 text.
                    mSymbol2.setText(getString(R.string.button_add) + " ");
                    //Setting the value2 text to be null
                    mValue2.setText(getString(R.string.value2_text));
                    //setting result textView's text to be null
                    mResult.setText("");
                    mAdd = true;
                }else{
                    //Do Nothing
                }
                break;
            case R.id.button_sub:
                if(mValue1.getText().toString().matches("")){
                    mValue1.setText(mValue2.getText().toString());
                    mSymbol2.setText(getString(R.string.button_sub) + " ");
                    mResult.setText("");
                    mValue2.setText(getString(R.string.value2_text));
                    mSub = true;
                }else{
                    //Do Nothing
                }
                break;
            case R.id.button_multiply:
                if(mValue1.getText().toString().matches("")){
                    mValue1.setText(mValue2.getText().toString());
                    mSymbol2.setText(getString(R.string.button_multiply) + " ");
                    mResult.setText("");
                    mValue2.setText(getString(R.string.value2_text));
                    mMult = true;
                }else{
                    //Do Nothing
                }
                break;
            case R.id.button_divide:
                if(mValue1.getText().toString().matches("")){
                    mValue1.setText(mValue2.getText().toString());
                    mSymbol2.setText(getString(R.string.button_divide) + " ");
                    mResult.setText("");
                    mValue2.setText(getString(R.string.value2_text));
                    mDiv = true;
                }else{
                    //Do Nothing
                }
                break;
            case R.id.button_percentage:
                if (mResult.getText().toString().length() == 0
                        && !mValue2.getText().toString().matches("")) {
                    //Getting the value2 text to the Double
                    Num1 = Double.parseDouble(mValue2.getText() + "");
                    //Dividing the Double from the value2 textView from 100
                    //and setting that value as the result textView text
                    mResult.setText(String.valueOf(Num1 / 100));
                    //setting the value2 text to be null
                    mValue2.setText("");
                    mValue1.setText("");
                    mPercent = true;
                } else {
                    if (!mValue2.getText().toString().matches("")){
                        Num1 = Double.parseDouble(mResult.getText() + "");
                        mResult.setText(String.valueOf(Num1 / 100));
                        mValue2.setText("");
                        mValue1.setText("");
                        mSymbol2.setText("");
                    }
                }
                break;
            case R.id.button_equals:
                //if else statement to check whether the value1 text is empty or not
                if (!mValue1.getText().toString().matches("")) {
                    //Setting the symbol2 textView's text
                    mSymbol1.setText(getString(R.string.button_equals) + " ");
                    //Setting the dashedLine visibility to be visible
                    dashedLine.setVisibility(View.VISIBLE);
                    //getting the value1 and value2 texts as Doubles
                    Num1 = Double.parseDouble(mValue1.getText() + "");
                    Num2 = Double.parseDouble(mValue2.getText() + "");
                    //if else statement to check the boolean
                    if (mAdd == true) {
                        mResult.setText(String.valueOf(Num1 + Num2));
                        mAdd = false;
                    } else if (mSub == true) {
                        mResult.setText(String.valueOf(Num1 - Num2));
                        mSub = false;
                    } else if (mMult == true) {
                        mResult.setText(String.valueOf(Num1 * Num2));
                        mMult = false;
                    } else if (mDiv == true) {
                        //if else statement to check if the value2 text is 0 or not
                        if (Num2 != 0) {
                            mResult.setText(String.valueOf(Num1 / Num2));
                        } else {
                            mResult.setTextSize(20);
                            mResult.setText("Can't divide by zero");
                            mSymbol1.setText("");
                        }
                        mDiv = false;
                    }
                } else {
                    mResult.setText("");
                }
                break;
            default:
                //Do nothing
                break;
        }
    }

}

