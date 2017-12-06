package com.hfad.wordgag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import android.text.method.ScrollingMovementMethod;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    int x = 0;
    boolean optionOnePicked;
    boolean optionTwoPicked;
    ArrayList<Integer> choices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Prevents screen rotation

        generatePhrase();
    }

    public void onReturn(View v) {
        x = 0;
        choices.clear();
        finish();
    }

    public void onBack(View v) {
        if(x == 1) {
            x = 0;
            generatePhrase();
        }
        else {
            x -= 2;
            onNext(v);
        }
    }

    public void pickOne(View v) {
        optionOnePicked = true;
        optionTwoPicked = false;
        onNext(v);
    }

    public void pickTwo(View v) {
        optionOnePicked = false;
        optionTwoPicked = true;
        onNext(v);
    }

    public void generatePhrase() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String noun = extras.getString("EXTRA_NOUN");
        int n = extras.getInt("n");

        ImageView image = (ImageView) findViewById(R.id.image);
        TextView phrase = (TextView) findViewById(R.id.phrase);
        phrase.setMovementMethod(new ScrollingMovementMethod());
        final TypeWriter tw = (TypeWriter) findViewById(R.id.tv);
        tw.setCharacterDelay(20);
        tw.setMovementMethod(new ScrollingMovementMethod());

        if(n == 0) {
            image.setImageResource(R.drawable.billy_boss);
            tw.animateText("Billy: \"You're late. AGAIN! Care to explain why?\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 1) {
            image.setImageResource(R.drawable.clueless_crooks);
            tw.animateText("Crook: \"Where do you think you're going? Heh, don't even think about escaping! We're the brown bag crooks, ya dig?\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 2) {
            image.setImageResource(R.drawable.dapper_doggo);

            if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                tw.animateText("Dapper Doggo: \"Woof. Pardon me human. You wouldn't happen to know where I can find an " + noun + ", would you?\"");
            }
            else {
                tw.animateText("Dapper Doggo: \"Woof. Pardon me human. You wouldn't happen to know where I can find a " + noun + ", would you?\"");
            }

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 3) {
            image.setImageResource(R.drawable.mystery_man);
            tw.animateText("Mysterious Stranger: \"Greetings.\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 4) {
            image.setImageResource(R.drawable.pete_police);
            tw.animateText("Police: \"Good evening. Hmm, mind explaining why you were going 30 above the speed limit?\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 5) {
            image.setImageResource(R.drawable.dancing_lobster);
            tw.animateText("The Dancing Lobster: \"Yoyoyo! They call me The Dancing Lobster!\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else if(n == 6) {
            image.setImageResource(R.drawable.akira);
            tw.animateText("Akira: \"Hey, can I ask you a question?\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
        else {
            image.setImageResource(R.drawable.wendy_wife);
            tw.animateText("Wendy: \"Sigh...we need to talk.\"");

            View b = findViewById(R.id.backButton);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionOne);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.optionTwo);
            b.setVisibility(View.GONE);
            b = findViewById(R.id.nextButton);
            b.setVisibility(View.VISIBLE);
            phrase.setVisibility(View.GONE);
            b = tw;
            b.setVisibility(View.VISIBLE);
        }
    }

    public void onNext(View v) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String noun = extras.getString("EXTRA_NOUN");
        String verb = extras.getString("EXTRA_VERB");
        String adjective = extras.getString("EXTRA_ADJECTIVE");
        int n = extras.getInt("n");

        String phraseText;
        ImageView image = (ImageView) findViewById(R.id.image);
        TextView phrase = (TextView) findViewById(R.id.phrase);
        phrase.setMovementMethod(new ScrollingMovementMethod());
        final TypeWriter tw = (TypeWriter) findViewById(R.id.tv);
        tw.setCharacterDelay(20);
        tw.setMovementMethod(new ScrollingMovementMethod());

        if(n == 0) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.billy_boss);
                Button optOne = (Button) findViewById(R.id.optionOne);
                Button optTwo = (Button) findViewById(R.id.optionTwo);

                optOne.setText("I was knocked unconscious...");
                optTwo.setText("A wizard is never late...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.billy_boss);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.VISIBLE);

                // This keeps track of the dialogue choices that the player makes.
                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                        tw.animateText("You: \"Sorry boss, I was knocked unconscious by an " + noun + " on the way to work.\"");
                    }
                    else {
                        tw.animateText("You: \"Sorry boss, I was knocked unconscious by a " + noun + " on the way to work.\"");
                    }
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"A wizard is never late, nor is he early. He arrives precisely when he means to.\"");
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.billy_boss);

                if(choices.contains(1)) {
                    if(adjective != null && (adjective.charAt(0) == 'a' || adjective.charAt(0) == 'e' || adjective.charAt(0) == 'i' || adjective.charAt(0) == 'o' || adjective.charAt(0) == 'u')) {
                        tw.animateText("You: \"Talk about an " + adjective + " situation, am I right?\"");
                    }
                    else {
                        tw.animateText("You: \"Talk about a " + adjective + " situation, am I right?\"");
                    }
                }
                else if(choices.contains(2)) {
                    if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                        tw.animateText("Billy: \"Hah! If I had an " + noun + " for every time I've heard that " + adjective + " excuse, I'd have one!\"");
                    }
                    else {
                        tw.animateText("Billy: \"Hah! If I had a " + noun + " for every time I've heard that " + adjective + " excuse, I'd have one!\"");
                    }
                }
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.billy_boss_2);
                tw.animateText("Billy: \"...\"");
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.billy_boss);

                if(choices.contains(1)) {
                    tw.animateText("Billy: \"Very well. Just don't let this become a routine.\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Billy: \"Ugh forget it. Just don't let this become a routine.\"");
                }
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.billy_boss);
                tw.animateText("Billy: \"Now if you'll excuse me, I'd like to return to my office.\"");
            }
            else if (x == 6) {
                x++;
                image.setImageResource(R.drawable.billy_boss);
                tw.animateText("Billy: \"The new season of 'The " + verb.substring(0, 1).toUpperCase() + verb.substring(1) + " Dead' is on and I don't want to miss another epis-\"");
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.billy_boss_2);
                tw.animateText("Billy: \"...\"");
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.billy_boss);
                tw.animateText("Billy: \"What I meant to say was, I have a lot of paperwork to deal with!\"");
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.billy_boss);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                tw.animateText("Billy: \"NOW QUIT DILLY-DALLYING AND GET BACK TO WORK!\"");
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(1)) {
                    phraseText = "Nice one! You've convinced your boss to excuse you. Let's hope you don't have recurring nightmares of that " + noun + ".";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(2)) {
                    phraseText = "Nice one! You've convinced your boss to excuse you. Seems like being a wizard has its perks, eh?";
                    phrase.setText(phraseText);
                }
            }
        }
        else if(n == 1) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);
                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Panic sarcastically)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Question appearance)");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"Golly gee willikers. Whatever shall I do?\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"So...why brown bags?\"");
                }
            }
            else if(x == 2) {
                x++;

                if(choices.contains(1)) {
                    image.setImageResource(R.drawable.clueless_crooks);
                    tw.animateText("Crooks: \"Bwahaha you better be scared! Tell you what, hand over that " + adjective + " " + noun + " of yours and we'll let you go unscathed, ya dig?\"");
                }
                else if(choices.contains(2)) {
                    image.setImageResource(R.drawable.clueless_crooks_2);
                    tw.animateText("Crooks: \"Because they're scary! Don't cha get it? Ugh just hand over that " + adjective + " " + noun + " of yours and we'll let you go unscathed, ya dig?\"");
                }

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.VISIBLE);
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("Sure.");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("No.");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = tw;
                b.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"Sure.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("You: \"No.\"");
                }
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks_2);

                if(choices.contains(3)) {
                    tw.animateText("Crook: \"Oh. Well that was easy. I guess all those " + verb + " routines payed off...\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("Crook: \"Dang! Foiled again. We should've planned this better instead of " + verb + " all day, ya dig?\"");
                }
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks_2);

                if(choices.contains(3)) {
                    tw.animateText("Crook: \"...ya dig?\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("Crook: \"Perhaps, in retrospect, we should've worn something more terrifying than brown bags. Like duffel bags, ya dig?\"");
                }
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);
                tw.animateText("Crook: \"...\"");
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.clueless_crooks);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                tw.animateText("Crook: \"What are you looking at? Run along now, ya dig?\"");
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(3)) {
                    phraseText = "Nice one! You've kindly gifted your " + adjective + " " + noun + " to the intimidating robbers. You have nine more of those at home anyway.";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(4)) {
                    phraseText = "Nice one! You've avoided an intimidating robbery. Your " + adjective + " " + noun + " continues to be in your possession.";
                    phrase.setText(phraseText);
                }
            }
        }
        else if(n == 2) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("Are you a humanoid dog?");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("Why?");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"Are you like a dog humanoid thing?\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"Why?\"");
                }
            }
            else if(x == 2) {
                x++;

                if(choices.contains(1)) {
                    image.setImageResource(R.drawable.dapper_doggo_2);
                    tw.animateText("Dapper Doggo: \"...!\"");
                }
                else if(choices.contains(2)) {
                    image.setImageResource(R.drawable.dapper_doggo);
                    tw.animateText("Dapper Doggo: \"...\"");
                }
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                if(choices.contains(1)) {
                    tw.animateText("Dapper Doggo: \"Bark. Beg pardon?\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Dapper Doggo: \"Bark. Alright, I can't tell you too much. I've been hired to find an escaped convict.\"");
                }
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                if(choices.contains(1)) {
                    tw.animateText("Dapper Doggo: \"Bow-wow. D-don't be ridiculous, I'm n-not a...\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Dapper Doggo: \"Bow-wow. Apparently, a deranged clown escaped the local prison. He and a bunch of his carnie buddies are planning on pulling off a heist at Ernie's Party Store.\"");
                }
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                if(choices.contains(1)) {
                    tw.animateText("Dapper Doggo: \"Arf. Okay, what gave it away? Was it the way I was " + verb + " behind the trashcan? Look, let's not apprise the world of my existence. It's bad enough I have to wear these stupid human clothes to shroud my identity.\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Dapper Doggo: \"Arf. That " + noun + " will be used as bait for my trap since that clown loves the stuff. I won't stop " + verb + " until I find and apprehend him. I was hoping you could help me out.\"");
                }

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("I'm late for work...");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("My girlfriend's upset with me...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"Sorry. I wish I can help with your " + noun + " situation, but unfortunately I'm late for work...again. My favorite movie, \'Eternal Sunshine of the " + adjective.substring(0, 1).toUpperCase() + adjective.substring(1) + " Mind 2: Electric Boogaloo\', was on last night. I ended up sleeping in.\"");
                }
                else if(choices.contains(4)) {
                    if(adjective != null && (adjective.charAt(0) == 'a' || adjective.charAt(0) == 'e' || adjective.charAt(0) == 'i' || adjective.charAt(0) == 'o' || adjective.charAt(0) == 'u')) {
                        tw.animateText("You: \"Sorry. I wish I can help with your " + noun + " situation, but unfortunately my girlfriend's upset with me...again. I have to find an " + adjective + " gift to give her. She likes " + adjective + " stuff.\"");
                    }
                    else {
                        tw.animateText("You: \"Sorry. I wish I can help with your " + noun + " situation, but unfortunately my girlfriend's upset with me...again. I have to find a " + adjective + " gift to give her. She likes " + adjective + " stuff.\"");
                    }
                }
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo_3);
                tw.animateText("Dapper Doggo: \"Jeez. That's RUFF, buddy.\"");
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.dapper_doggo_3);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                tw.animateText("Dapper Doggo: \"Quack. Well good luck to you. I'm off to find that " + noun + ". Au revoir human.\"");
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                phraseText = "Nice one! You've avoided further distractions. Let's hope Dapper Doggo one day finds that " + noun + "!";
                phrase.setText(phraseText);
            }
        }
        else if(n == 3) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.mystery_man);
                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Stare)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Scream)");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"...\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"Gah!\"");
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.mystery_man);
                tw.animateText("Mysterious Stranger: \"...\"");
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.mystery_man_3);

                if(choices.contains(1)) {
                    tw.animateText("Mysterious Stranger: \"Um, are you ok?\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Mysterious Stranger: \"What a strange way of greeting someone.\"");
                }

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.mystery_man_3);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Stare)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Apologize)");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(3));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"...\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("You: \"Sorry, you startled me. The same way my " + adjective + " neighbor startled me while I was " + verb + " on my front lawn this morning.\"");
                }
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                if(choices.contains(3)) {
                    tw.animateText("Mysterious Stranger: \"You know, I've met plenty of " + adjective + " people who enjoy " + verb + " for a living. This is the first time I've met someone who genuinely creeps me out.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("Mysterious Stranger: \"I see.\"");
                }
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.mystery_man);
                tw.animateText("Mysterious Stranger: \"Well listen, I want you to take this.\"");
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                    tw.animateText("Mysterious Stranger: \"It's an " + noun + ". When the time comes, it'll serve as an important asset.\"");
                }
                else {
                    tw.animateText("Mysterious Stranger: \"It's a " + noun + ". When the time comes, it'll serve as an important asset.\"");
                }

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Stare)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("How?");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(5)) {
                    choices.removeAll(Collections.singletonList(5));
                }
                else if(choices.contains(6)) {
                    choices.removeAll(Collections.singletonList(6));
                }
            }
            else if(x == 10) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(5) && !choices.contains(6)) {
                    if (optionOnePicked) {
                        if (!choices.contains(5)) {
                            choices.add(5);
                        }

                        if (choices.contains(6)) {
                            choices.removeAll(Collections.singletonList(6));
                        }
                    } else {
                        if (!choices.contains(6)) {
                            choices.add(6);
                        }

                        if (choices.contains(5)) {
                            choices.removeAll(Collections.singletonList(5));
                        }
                    }
                }

                if(choices.contains(5)) {
                    tw.animateText("You: \"...\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("You: \"And how exactly will this " + noun + " be of use to me?\"");
                }
            }
            else if(x == 11) {
                x++;

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.mystery_man_2);
                    tw.animateText("Mysterious Stranger: \"Hey, quit that!\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.mystery_man);
                    tw.animateText("Mysterious Stranger: \"Shh. Only time - whatever that may be - will tell.\"");
                }
            }
            else if(x == 12) {
                x++;

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.mystery_man_2);
                    tw.animateText("Mysterious Stranger: \"I can't take you seriously with the staring.\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.mystery_man);
                    tw.animateText("Mysterious Stranger: \"So until then...\"");
                }
            }
            else if(x == 13) {
                x++;
                image.setImageResource(R.drawable.mystery_man);

                if(choices.contains(5)) {
                    tw.animateText("Mysterious Stranger: \"Sigh.\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("Mysterious Stranger: \"Live life...\"");
                }
            }
            else if(x == 14) {
                x++;
                image.setImageResource(R.drawable.mystery_man_4);

                if(choices.contains(5)) {
                    tw.animateText("Mysterious Stranger: \"Perhaps...\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("Mysterious Stranger: \"Follow your dreams...\"");
                }
            }
            else if(x == 15) {
                x++;
                image.setImageResource(R.drawable.mystery_man_5);

                if(choices.contains(5)) {
                    tw.animateText("Mysterious Stranger: \"This was...\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("Mysterious Stranger: \"And...\"");
                }
            }
            else if(x == 16) {
                x++;
                image.setImageResource(R.drawable.mystery_man_6);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                if(choices.contains(5)) {
                    tw.animateText("Mysterious Stranger: \"A mistake...\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("Mysterious Stranger: \"Uh, I don't know where I'm going with this...\"");
                }
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                    phraseText = "Nice one! You've obtained an " + noun + " from a creepy ominous stranger. What could possibly go wrong?";
                    phrase.setText(phraseText);
                }
                else {
                    phraseText = "Nice one! You've obtained a " + noun + " from a creepy ominous stranger. What could possibly go wrong?";
                    phrase.setText(phraseText);
                }
            }
        }
        else if(n == 4) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.pete_police);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("I was chased...");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("I was conned...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.pete_police);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    if(noun != null && (noun.charAt(0) == 'a' || noun.charAt(0) == 'e' || noun.charAt(0) == 'i' || noun.charAt(0) == 'o' || noun.charAt(0) == 'u')) {
                        tw.animateText("You: \"Well if you were being chased by a deranged clown that kept throwing an " + noun + " at you, then wouldn't you do the same thing?\"");
                    }
                    else {
                        tw.animateText("You: \"Well if you were being chased by a deranged clown that kept throwing a " + noun + " at you, then wouldn't you do the same thing?\"");
                    }
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"I was conned by a deranged clown who sold me a fake " + noun + ". I have to find him before he gets away with my money. You'd do the same thing, right?\"");
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.pete_police_2);
                tw.animateText("Police: \"Yeah, I gue-\"");
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.pete_police_3);
                tw.animateText("Police: \"Wait what?\"");
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.pete_police);
                tw.animateText("Police: \"How exactly did this happen?\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.pete_police);

                Button optOne = (Button) findViewById(R.id.optionOne);
                Button optTwo = (Button) findViewById(R.id.optionTwo);

                if(choices.contains(1)) {
                    optOne.setText("Caught him in a dilapidated cabin...");
                    optTwo.setText("Caught him in a swimming pool...");
                }
                else if(choices.contains(2)) {
                    optOne.setText("Shop in the woods...");
                    optTwo.setText("Shop in the alley...");
                }

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.pete_police);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(3));
                        }
                    }
                }

                if (choices.contains(1)) {
                    if (choices.contains(3)) {
                        tw.animateText("You: \"I caught him " + verb + " in a dilapidated cabin in the woods. He saw me and gave chase! Absurd, is it not?\"");
                    }
                    else if (choices.contains(4)) {
                        tw.animateText("You: \"I caught him " + verb + " in my neighbor's swimming pool. He saw me and gave chase! Absurd, is it not?\"");
                    }
                }
                else if (choices.contains(2)) {
                    if (choices.contains(3)) {
                        tw.animateText("You: \"He had a little 'shop' set up deep in the woods. He convinced me that the " + noun + " would greatly improve my " + verb + " so I bought it. It turned out to be a sham! Absurd is it not?\"");
                    }
                    else if (choices.contains(4)) {
                        tw.animateText("You: \"He had a little 'shop' set up in a secluded alley. He convinced me that the " + noun + " would greatly improve my " + verb + " so I bought it. It turned out to be a sham! Absurd is it not?\"");
                    }
                }
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.pete_police);
                tw.animateText("Police: \"Absurd indeed. This clown reminds me of my ex back in high school. I'll never forget her " + adjective + " smile.\"");
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.pete_police);
                tw.animateText("Police: \"...\"");
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.pete_police_2);
                tw.animateText("Police: \"Sigh...alright. I'll let you off with a warning.\"");
            }
            else if(x == 10) {
                x++;
                image.setImageResource(R.drawable.pete_police);
                tw.animateText("Police: \"Just slow down will ya? And stay away from deranged clowns.\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 11) {
                x++;
                image.setImageResource(R.drawable.pete_police);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Thank him)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Speed off)");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(5)) {
                    choices.removeAll(Collections.singletonList(5));
                }
                else if(choices.contains(6)) {
                    choices.removeAll(Collections.singletonList(6));
                }
            }
            else if(x == 12) {
                x++;

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(5) && !choices.contains(6)) {
                    if (optionOnePicked) {
                        if (!choices.contains(5)) {
                            choices.add(5);
                        }

                        if (choices.contains(6)) {
                            choices.removeAll(Collections.singletonList(6));
                        }
                    } else {
                        if (!choices.contains(6)) {
                            choices.add(6);
                        }

                        if (choices.contains(5)) {
                            choices.removeAll(Collections.singletonList(5));
                        }
                    }
                }

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.pete_police);
                    tw.animateText("You: \"Will do. And thanks, I'll take this as a...\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.pete_police_3);
                    tw.animateText("You: \"Later sucka!\"");
                }
            }
            else if(x == 13) {
                x++;

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.pete_police_3);
                    tw.animateText("You: \"...JESTER of goodwill!\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.pete_police_5);
                    tw.animateText("Police: \"...\"");
                }
            }
            else if(x == 14) {
                x++;

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.pete_police_4);
                    tw.animateText("Police: \"Ohh you! Hahahahahahahahaha-\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.pete_police_6);
                    tw.animateText("Police: \"Huh...\"");
                }
            }
            else if(x == 15) {
                x++;

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.pete_police);
                    tw.animateText("Police: \"Sod off.\"");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.pete_police_7);
                    tw.animateText("Police: \"Okay then.\"");
                }
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(1)) {
                    phraseText = "Nice one! You've avoided probable arrest thanks to that deranged clown! You've decided to keep his " + noun + " as a memorabilia.";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(2)) {
                    phraseText = "Nice one! You've avoided probable arrest thanks to that deranged clown! You've decided to keep the fake " + noun + " as a reminder to never trust clowns again.";
                    phrase.setText(phraseText);
                }
            }
        }
        else if(n == 5) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster);
                tw.animateText("The Dancing Lobster: \"One, because I love to dance. And deux, because I have a lobster-shaped birthmark on my butt cheek.\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("...");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("TMI...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"...\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"Too much inform-\"");
                }
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster);
                tw.animateText("The Dancing Lobster: \"Ch-ch-check out my new dance move fam. I call it...\"");
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_2);
                tw.animateText("The Dancing Lobster: \"The " + verb + " shrimp!\"");
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_3);
                tw.animateText("The Dancing Lobster: *Grunts*");
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_4);
                tw.animateText("The Dancing Lobster: \"AW YE.\"");
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_5);
                tw.animateText("The Dancing Lobster: \"Ya jealous?\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_5);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("Maybe a little.");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("Eh.");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_5);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(3));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"Maybe a little.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("You: \"Eh.\"");
                }
            }
            else if(x == 10) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.dancing_lobster_2);
                    tw.animateText("The Dancing Lobster: \"Haha thought so! Ok your turn. Show us your shabby dance move!\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.dancing_lobster_6);
                    tw.animateText("The Dancing Lobster: \"Hmph. Well let's see YOUR dance move, guppy!\"");
                }

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 11) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.dancing_lobster_2);
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.dancing_lobster_6);
                }

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Do the funky " + noun + ")");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Do the disco " + noun + ")");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(5)) {
                    choices.removeAll(Collections.singletonList(5));
                }
                else if(choices.contains(6)) {
                    choices.removeAll(Collections.singletonList(6));
                }
            }
            else if(x == 12) {
                x++;

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(5) && !choices.contains(6)) {
                    if (optionOnePicked) {
                        if (!choices.contains(5)) {
                            choices.add(5);
                        }

                        if (choices.contains(6)) {
                            choices.removeAll(Collections.singletonList(6));
                        }
                    } else {
                        if (!choices.contains(6)) {
                            choices.add(6);
                        }

                        if (choices.contains(5)) {
                            choices.removeAll(Collections.singletonList(5));
                        }
                    }
                }

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.dancing_lobster_2);
                    tw.animateText("You: \"I call this dance move...\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.dancing_lobster_6);
                    tw.animateText("You: \"I call this dance move...\"");
                }
            }
            else if(x == 13) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_5);

                if(choices.contains(5)) {
                    tw.animateText("You: \"The funky " + noun + "!\"");
                }
                else if(choices.contains(6)) {
                    tw.animateText("You: \"The disco " + noun + "!\"");
                }
            }
            else if(x == 14) {
                x++;

                if(choices.contains(5)) {
                    image.setImageResource(R.drawable.dancing_lobster_7);
                    tw.animateText("You: *Grunts*");
                }
                else if(choices.contains(6)) {
                    image.setImageResource(R.drawable.dancing_lobster_8);
                    tw.animateText("You: *Grunts*");
                }
            }
            else if(x == 15) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster_2);

                if(noun != null && !noun.equals("lobster")) {
                    tw.animateText("The Dancing Lobster: \"Wow. That was...absolutely beautiful!\"");
                }
                else {
                    tw.animateText("The Dancing Lobster: \"Wow. That was...absolutely beautiful! And the fact that you used " + noun + " in the name is worthy of high praise.\"");
                }
            }
            else if(x == 16) {
                x++;
                image.setImageResource(R.drawable.dancing_lobster);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);

                tw.animateText("The Dancing Lobster: \"As a token of respect, let me give you this box of " + adjective + " goatfishes. You've earned it buddy!\"");
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(5)) {
                    phraseText = "Nice one! You've outdanced the fabled Dancing Lobster. The funky " + noun + " became the next annoying internet dance fad!";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(6)) {
                    phraseText = "Nice one! You've outdanced the fabled Dancing Lobster. The disco " + noun + " became the next annoying internet dance fad!";
                    phrase.setText(phraseText);
                }
            }
        }
        else if(n == 6) {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.akira);
                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("Sure.");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("No...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.akira);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"Sure.\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"No...\"");
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.akira_2);

                if(choices.contains(1)) {
                    tw.animateText("Akira: \"Huh, you're the first decent person I met today. Everyone else either shrugged me off or flat-out ignored me.\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Akira: \"Well I'll ask it anyway.\"");
                }
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.akira);
                tw.animateText("Akira: \"So have you ever thought of the possibility that you're the only one that exists in this reality?\"");
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.akira);
                tw.animateText("Akira: \"I mean the only thing that's real would be the observer in your head right? The self.\"");
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.akira);
                tw.animateText("Akira: \"Everything else could be your imagination...or a simulation. The thought of being the only conscience in the cosmos, it really makes you feel lonely. That your entire reality is just a manifestation fabricated by your own mind.\"");
            }
            else if (x == 6) {
                x++;
                image.setImageResource(R.drawable.akira_2);
                tw.animateText("Akira: \"Like that abandoned " + noun + " over there. That could be fake. Or that deranged clown " + verb + " behind the bush. That could be fake too.\"");
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.akira);
                tw.animateText("Akira: \"For all I know, I may just be another fictional character in some CS student's mobile app project.\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 8) {
                x++;
                image.setImageResource(R.drawable.akira);
                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("But you ARE.");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("...");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 9) {
                x++;
                image.setImageResource(R.drawable.akira);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(3));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"But you ARE.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("You: \"...\"");
                }
            }
            else if(x == 10) {
                x++;
                image.setImageResource(R.drawable.akira_2);

                if(choices.contains(3)) {
                    tw.animateText("Akira: \"...\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("Akira: \"Yup. That's something to think about.\"");
                }
            }
            else if (x == 11) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_4);
                    tw.animateText("Akira: \"No...it can't be. You mean this whole time...\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_3);
                    tw.animateText("Akira: \"Well thanks for listening to me.\"");
                }
            }
            else if (x == 12) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_5);
                    tw.animateText("Akira: \"I-I'm just a poorly drawn MS Paint character? A character for some " + adjective + " word game called 'Word Gag'??\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_3);
                    tw.animateText("Akira: \"Initially I thought I was just losing my head...\"");
                }
            }
            else if (x == 13) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_5);
                    tw.animateText("Akira: \"Wait wait wait. So I'm just scripted to implement the words: " + noun + ", " + verb + ", and " + adjective + " into my dialogue just to satisfy the player???\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_2);
                    tw.animateText("Akira: \"Thinking that I was just a figment of someone's imagination.\"");
                }
            }
            else if (x == 14) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_6);
                    tw.animateText("Akira: \"IT ALL MAKES SENSE. NO WONDER I'M JUST A BUNCH OF WHITE LINES RESEMBLING A WOMAN. NO WONDER I'M SPEAKING IN TEXT. NO WONDER YOU'RE ABLE TO PAGE THROUGH OUR CONVERSATION.\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_3);
                    tw.animateText("Akira: \"But your " + adjective + " words of wisdom, or lack thereof, really validated my existence.\"");
                }
            }
            else if (x == 15) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_7);
                    tw.animateText("Akira: \"ANY MINUTE NOW, I-I'LL JUST BE ERASED AND REPLACED BY ANOTHER CHARACTER UNTIL SOME ALGORITHM RANDOMLY CHOOSES ME AGAIN AND I'LL HAVE TO REPEAT THIS MADNESS...\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_3);
                    tw.animateText("Akira: \"...\"");
                }
            }
            else if (x == 16) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_8);
                    tw.animateText("Akira: \"OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVER AND OVE-\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_4);
                    tw.animateText("Akira: \"Oh look at the time! I need to get going.\"");
                }
            }
            else if (x == 17) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.akira_9);
                    tw.animateText("404 Error:: \"Lorem ipsum dolor s#t amet, c?+=*ctetur adipiscing elit. Pr!@#ent sed libero h/ndrerit::: diam sagittis ma$%^&ada id non leo. Pha$ellus l3ctus.\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.akira_3);
                    tw.animateText("Akira: \"Catch you around stranger!\"");
                }

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(3)) {
                    phraseText = "Nice one! You've managed to drive someone insane with just a few words. Nothing better than breaking the fourth wall.";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(4)) {
                    phraseText = "Nice one!  Your " + adjective + " words of wisdom, or lack thereof, really made her day. Nothing better than a casual conversation that questions your existence.";
                    phrase.setText(phraseText);
                }
            }
        }
        else {
            if(x == 0) {
                x++;
                image.setImageResource(R.drawable.wendy_wife);

                Button optOne = (Button) findViewById(R.id.optionOne);
                Button optTwo = (Button) findViewById(R.id.optionTwo);

                optOne.setText("...");
                optTwo.setText("About what?");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(1)) {
                    choices.removeAll(Collections.singletonList(1));
                }
                else if(choices.contains(2)) {
                    choices.removeAll(Collections.singletonList(2));
                }
            }
            else if(x == 1) {
                x++;
                image.setImageResource(R.drawable.wendy_wife);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(1) && !choices.contains(2)) {
                    if (optionOnePicked) {
                        if (!choices.contains(1)) {
                            choices.add(1);
                        }

                        if (choices.contains(2)) {
                            choices.removeAll(Collections.singletonList(2));
                        }
                    } else {
                        if (!choices.contains(2)) {
                            choices.add(2);
                        }

                        if (choices.contains(1)) {
                            choices.removeAll(Collections.singletonList(1));
                        }
                    }
                }

                if(choices.contains(1)) {
                    tw.animateText("You: \"...\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("You: \"About what?\"");
                }
            }
            else if(x == 2) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_2);

                if(choices.contains(1)) {
                    tw.animateText("Wendy: \"Ugh. Don't give me that look. I know you were at her house again. You two were " + verb + " together behind my back.\"");
                }
                else if(choices.contains(2)) {
                    tw.animateText("Wendy: \"Really?? Don't act like you don't know. You were at her house again, weren't you? You two were " + verb + " together behind my back.\"");
                }
            }
            else if(x == 3) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_3);
                tw.animateText("Wendy: \"Unfortunately, my patience level exceeded its threshold. Our relationship became nothing more than a cesspool of...\"");
            }
            else if(x == 4) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_4);
                tw.animateText("Wendy: \"...pure deception.\"");
            }
            else if(x == 5) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_4);
                tw.animateText("Wendy: \"...\"");

                View b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
            }
            else if(x == 6) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_4);

                Button optOne = (Button) findViewById(R.id.optionOne);
                optOne.setText("(Appease her)");
                Button optTwo = (Button) findViewById(R.id.optionTwo);
                optTwo.setText("(Break up with her)");

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                b = optOne;
                b.setVisibility(View.VISIBLE);
                b = optTwo;
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.GONE);

                if(choices.contains(3)) {
                    choices.removeAll(Collections.singletonList(3));
                }
                else if(choices.contains(4)) {
                    choices.removeAll(Collections.singletonList(4));
                }
            }
            else if(x == 7) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_4);

                View b = findViewById(R.id.optionOne);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.optionTwo);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.backButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);

                if(!choices.contains(3) && !choices.contains(4)) {
                    if (optionOnePicked) {
                        if (!choices.contains(3)) {
                            choices.add(3);
                        }

                        if (choices.contains(4)) {
                            choices.removeAll(Collections.singletonList(4));
                        }
                    } else {
                        if (!choices.contains(4)) {
                            choices.add(4);
                        }

                        if (choices.contains(3)) {
                            choices.removeAll(Collections.singletonList(3));
                        }
                    }
                }

                if(choices.contains(3)) {
                    tw.animateText("You: \"But she's only a friend.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("You: \"Listen. I don't know how else to say this...but I'm breaking up with you.\"");
                }
            }
            else if(x == 8) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_2);
                    tw.animateText("Wendy: \"Hmph. Do you even taste your words before you spit them out?\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_4);
                    tw.animateText("Wendy: \"...\"");
                }
            }
            else if(x == 9) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_3);
                    tw.animateText("Wendy: \"I'd rather hear the aching truth then to be wrongfully appeased by your pitiful lies.\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_4);
                    tw.animateText("Wendy: \"Oh.\"");
                }
            }
            else if(x == 10) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_4);
                    tw.animateText("Wendy: \"I don't think I can trust you anymore.\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_4);
                    tw.animateText("Wendy: \"I see.\"");
                }
            }
            else if(x == 11) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_4);

                if(choices.contains(3)) {
                    if(adjective != null && (adjective.charAt(0) == 'a' || adjective.charAt(0) == 'e' || adjective.charAt(0) == 'i' || adjective.charAt(0) == 'o' || adjective.charAt(0) == 'u')) {
                        tw.animateText("You: \"But I brought you an " + adjective + " " + noun + " as a gift.\"");
                    }
                    else {
                        tw.animateText("You: \"But I brought you a " + adjective + " " + noun + " as a gift.\"");
                    }
                }
                else if(choices.contains(4)) {
                    tw.animateText("Wendy: \"Well if that's the case then fine.\"");
                }
            }
            else if(x == 12) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife);
                    tw.animateText("Wendy: \"Are you serious?\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_4);
                    tw.animateText("Wendy: \"Everything's...fine.\"");
                }
            }
            else if(x == 13) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife);
                    tw.animateText("Wendy: \"...\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_5);
                    tw.animateText("Wendy: \"In fact, I don't even need another " + adjective + " " + noun + " to calm my nerves. Because everything's totally cool!\"");
                }
            }
            else if(x == 14) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_5);
                    tw.animateText("Wendy: \"I love it! And you remembered that I like " + adjective + " stuff. How thoughtful!\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_6);
                    tw.animateText("Wendy: \"Heh...hehe.\"");
                }
            }
            else if(x == 15) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_6);
                    tw.animateText("Wendy: \"Ok, I guess I'll give you another chance.\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife);
                    tw.animateText("Wendy: \"Wait, w-where do you think you're going? You think you're just free to up and leave, huh?\"");
                }
            }
            else if(x == 16) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_6);
                    tw.animateText("Wendy: \"However, if I catch you " + verb + " at her place again...\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_5);
                    tw.animateText("Wendy: \"Hehehe, well aren't you adorable. Hey let me tell you something about myself.\"");
                }
            }
            else if(x == 17) {
                x++;
                image.setImageResource(R.drawable.wendy_wife_7);

                if(choices.contains(3)) {
                    tw.animateText("Wendy: \"I'LL MAKE YOU REGRET EVERYTHING.\"");
                }
                else if(choices.contains(4)) {
                    tw.animateText("Wendy: \"I DON'T LET THINGS GO TOO EASILY.\"");
                }
            }
            else if(x == 18) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_6);
                    tw.animateText("Wendy: \"Capiche?\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_7);
                    tw.animateText("Wendy: \"AND IF I CAN'T HAVE YOU, THEN NOBODY CAAAAAAAN!!!\"");
                }
            }
            else if(x == 19) {
                x++;

                if(choices.contains(3)) {
                    image.setImageResource(R.drawable.wendy_wife_5);
                    tw.animateText("Wendy: \"Okie dokie thanks honey you're the best I love you very much and stuff, byeeee!\"");
                }
                else if(choices.contains(4)) {
                    image.setImageResource(R.drawable.wendy_wife_8);
                    tw.animateText("Wendy: \"GWAAAAAAAAAAAAAAAAAAAAAAAHHHH!!!\"");
                }

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.VISIBLE);
                tw.setVisibility(View.VISIBLE);
                phrase.setVisibility(View.GONE);
            }
            else {
                x++;
                image.setImageResource(R.drawable.check);

                View b = findViewById(R.id.nextButton);
                b.setVisibility(View.GONE);
                tw.setVisibility(View.GONE);
                phrase.setVisibility(View.VISIBLE);

                if(choices.contains(3)) {
                    phraseText = "Nice one! You've successfully appeased your girlfriend...again! Good thing she likes " + adjective + " stuff, am I right?";
                    phrase.setText(phraseText);
                }
                else if(choices.contains(4)) {
                    if(adjective != null && (adjective.charAt(0) == 'a' || adjective.charAt(0) == 'e' || adjective.charAt(0) == 'i' || adjective.charAt(0) == 'o' || adjective.charAt(0) == 'u')) {
                        phraseText = "Nice one! You've managed to escape a dysfunctional relationship. Unfortunately, you fell victim to Wendy's wrath and have to spend the rest of your life looking like an " + adjective + " " + noun + ".";
                        phrase.setText(phraseText);
                    }
                    else {
                        phraseText = "Nice one! You've managed to escape a dysfunctional relationship. Unfortunately, you fell victim to Wendy's wrath and have to spend the rest of your life looking like a " + adjective + " " + noun + ".";
                        phrase.setText(phraseText);
                    }
                }
            }
        }
    }
}