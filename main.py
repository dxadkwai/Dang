import turtle
import pandas as pd

screen = turtle.Screen()
screen.title("U.S. States Game")

# Optional: Add a map image as the background
screen.addshape("blank_states_img.gif")
turtle.shape("blank_states_img.gif")

# Load the data
data = pd.read_csv("50_states.csv")
all_states = data.state.to_list()
guessed_states = []

while len(guessed_states) < 50:
    answer_state = screen.textinput(title=f"{len(guessed_states)}/50 States Correct",
                                    prompt="What's another state's name?").title()

    # Secret exit command
    if answer_state == "Exit":
        # Create a list of states the user missed
        missing_states = [state for state in all_states if state not in guessed_states]
        new_data = pd.DataFrame(missing_states)
        new_data.to_csv("states_to_learn.csv")
        break

    if answer_state in all_states:
        guessed_states.append(answer_state)
        t = turtle.Turtle()
        t.hideturtle()
        t.penup()

        # Get the row of the guessed state to find its coordinates
        state_data = data[data.state == answer_state]
        t.goto(state_data.x.item(), state_data.y.item())
        t.write(answer_state)

# Keep the window open
screen.exitonclick()