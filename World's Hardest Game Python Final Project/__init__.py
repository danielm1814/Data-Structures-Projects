import arcade, ctypes

#This is the Game class where the entire class is built
class Game(arcade.Window):
    #This makes the window and sets the basic variables and is the Constructor
    def __init__(self, width, height, title):
        super().__init__(width, height, title)

        #Sets the starting location of the window
        self.set_location(200, 50)

        #Sets the background color
        arcade.set_background_color(arcade.color.DEEP_SKY_BLUE)

        #Obstacle 1 position and speed
        self.a_y = 100
        self.a_x = 100
        self.ax_speed = 100
        self.ay_speed = 125

        # Obstacle 2 position and speed
        self.b_y = 200
        self.b_x = 200
        self.bx_speed = 125
        self.by_speed = 100

        # Obstacle 3 position and speed
        self.c_y = 300
        self.c_x = 400
        self.cx_speed = 100

        #Obstacle 4 position and speed
        self.d_y = 200
        self.d_x = 400
        self.dx_speed = 150
        self.dy_speed = 100

        # Player position and speed
        self.player_x = 100
        self.player_y = 150
        self.player_speed = 50

        self.tries = 1

        self.checkpoint1 = False
        self.checkpoint2 = False
        self.checkpoint3 = False

        #Updates movement of player
        self.left = False
        self.right = False
        self.up = False
        self.down = False
        self.space = False

    #This draws the shapes continuously everytime on_update is called
    def on_draw(self):
        arcade.start_render()
        arcade.draw_lrtb_rectangle_filled(self.a_x, self.a_x+30, self.a_y+30, self.a_y, arcade.color.BLACK)
        arcade.draw_lrtb_rectangle_filled(self.b_x, self.b_x + 50, self.b_y+50, self.b_y, arcade.color.BLACK)
        arcade.draw_lrtb_rectangle_filled(self.c_x, self.c_x + 40, self.c_y + 40, self.c_y, arcade.color.YELLOW)
        arcade.draw_lrtb_rectangle_filled(self.d_x, self.d_x + 40, self.d_y + 40, self.d_y, arcade.color.YELLOW)
        arcade.draw_lrtb_rectangle_filled(500, 525, 525, 500, arcade.color.RED)
        arcade.draw_lrtb_rectangle_filled(500, 525, 100, 75, arcade.color.RED)
        arcade.draw_lrtb_rectangle_filled(75, 100, 525, 500, arcade.color.RED)
        arcade.draw_lrtb_rectangle_filled(self.player_x, self.player_x + 25, self.player_y, self.player_y-25, arcade.color.GREEN)

    #Updates the shapes and player move the objects
    def on_update(self, delta_time):
        #Moves Obstacle 1
        self.a_x += self.ax_speed * delta_time
        self.a_y += self.ay_speed * delta_time

        if self.a_x > 570 or self.a_x < 0:
            self.ax_speed *= -1
        if self.a_y > 570 or self.a_y < 0:
            self.ay_speed *= -1

        #Moves Obstacle 2
        self.b_x += self.bx_speed * delta_time
        self.b_y += self.by_speed * delta_time

        if self.b_x > 550 or self.b_x < 0:
            self.bx_speed *= -1
        if self.b_y > 550 or self.b_y < 0:
            self.by_speed *= -1

        #Moves Obstacle 3
        self.c_x += self.cx_speed * delta_time

        if self.c_x > 560 or self.c_x < 0:
            self.cx_speed *= -1

        # Moves Obstacle 4
        self.d_x += self.dx_speed * delta_time
        self.d_y += self.dy_speed * delta_time

        if self.d_x > 560 or self.d_x < 0:
            self.dx_speed *= -1
        if self.d_y > 560 or self.d_y < 0:
            self.dy_speed *= -1

        #Moves the Player
        if self.player_x < 575:
            if self.right:
                self.player_x += self.player_speed * delta_time
        if self.player_x > 0:
            if self.left:
                self.player_x -= self.player_speed * delta_time
        if self.player_y < 600:
            if self.up:
                self.player_y += self.player_speed * delta_time
        if self.player_y > 25:
            if self.down:
                self.player_y -= self.player_speed * delta_time

        #Checks if Player Lost

        #Checks if hit Obstacle 1 and if hit player returns to start
        if self.player_x >= self.a_x and self.player_x <= self.a_x + 30:
            if self.player_y >= self.a_y and self.player_y <= self.a_y + 30:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.a_x and self.player_x +25 <= self.a_x + 30:
            if self.player_y >= self.a_y and self.player_y <= self.a_y + 30:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.a_x and self.player_x + 25 <= self.a_x + 30:
            if self.player_y - 25 >= self.a_y and self.player_y -25 <= self.a_y + 30:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x >= self.a_x and self.player_x <= self.a_x + 30:
            if self.player_y - 25 >= self.a_y and self.player_y - 25 <= self.a_y + 30:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False

        #Checks if hit Obstacle 2 and if hit player returns to start
        if self.player_x >= self.b_x and self.player_x <= self.b_x + 50:
            if self.player_y >= self.b_y and self.player_y <= self.b_y + 50:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.b_x and self.player_x +25 <= self.b_x + 50:
            if self.player_y >= self.b_y and self.player_y <= self.b_y + 50:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.b_x and self.player_x + 25 <= self.b_x + 50:
            if self.player_y - 25 >= self.b_y and self.player_y -25 <= self.b_y + 50:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x >= self.b_x and self.player_x <= self.b_x + 50:
            if self.player_y - 25 >= self.b_y and self.player_y - 25 <= self.b_y + 50:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False

        #Checks if hit Obstacle 3 and if hit player returns to start
        if self.player_x >= self.c_x and self.player_x <= self.c_x + 40:
            if self.player_y >= self.c_y and self.player_y <= self.c_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.c_x and self.player_x +25 <= self.c_x + 40:
            if self.player_y >= self.c_y and self.player_y <= self.c_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.c_x and self.player_x + 25 <= self.c_x + 40:
            if self.player_y - 25 >= self.c_y and self.player_y -25 <= self.c_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x >= self.c_x and self.player_x <= self.c_x + 40:
            if self.player_y - 25 >= self.c_y and self.player_y - 25 <= self.c_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False

        # Checks if hit Obstacle 4 and if hit player returns to start
        if self.player_x >= self.d_x and self.player_x <= self.d_x + 40:
            if self.player_y >= self.d_y and self.player_y <= self.d_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.d_x and self.player_x + 25 <= self.d_x + 40:
            if self.player_y >= self.d_y and self.player_y <= self.d_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x + 25 >= self.d_x and self.player_x + 25 <= self.d_x + 40:
            if self.player_y - 25 >= self.d_y and self.player_y - 25 <= self.d_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False
        if self.player_x >= self.d_x and self.player_x <= self.d_x + 40:
            if self.player_y - 25 >= self.d_y and self.player_y - 25 <= self.d_y + 40:
                self.player_x = 100
                self.player_y = 150
                self.tries += 1
                self.checkpoint1 = False
                self.checkpoint2 = False
                self.checkpoint3 = False



        #Check if Player Reached Checkpoint 1
        if self.space:
            strs = "You Win! It took you " + str(self.tries) + str(" times")
            if self.player_x >= 500 and self.player_x <= 525:
                if self.player_y >= 500 and self.player_y <= 525:
                    self.checkpoint1 = True
            if self.player_x + 25 >= 500 and self.player_x + 25 <= 525:
                if self.player_y >= 500 and self.player_y <= 525:
                    self.checkpoint1 = True
            if self.player_x >= 500 and self.player_x <= 525:
                if self.player_y - 25 >= 500 and self.player_y - 25 <= 525:
                    self.checkpoint1 = True
            if self.player_x + 25 >= 500 and self.player_x + 25 <= 525:
                if self.player_y - 25 >= 500 and self.player_y - 25 <= 525:
                    self.checkpoint1 = True
        #Checks if Player Reached Checkpoint 2
        if self.space:
            if self.player_x >= 500 and self.player_x <= 525:
                if self.player_y >= 75 and self.player_y <= 100:
                    self.checkpoint2 = True
            if self.player_x + 25 >= 500 and self.player_x + 25 <= 525:
                if self.player_y >= 75 and self.player_y <= 100:
                    self.checkpoint2 = True
            if self.player_x >= 500 and self.player_x <= 525:
                if self.player_y - 25 >= 75 and self.player_y - 25 <= 100:
                    self.checkpoint2 = True
            if self.player_x + 25 >= 500 and self.player_x + 25 <= 525:
                if self.player_y - 25 >= 75 and self.player_y - 25 <= 100:
                    self.checkpoint2 = True
        #Checks if Player Reached Checkpoint 3
        if self.space:
            strs = "You Win! It took you " + str(self.tries) + str(" times")
            if self.player_x >= 75 and self.player_x <= 100:
                if self.player_y >= 500 and self.player_y <= 525:
                    self.checkpoint3 = True
            if self.player_x + 25 >= 75 and self.player_x + 25 <= 100:
                if self.player_y >= 500 and self.player_y <= 525:
                    self.checkpoint3 = True
            if self.player_x >= 75 and self.player_x <= 100:
                if self.player_y - 25 >= 500 and self.player_y - 25 <= 525:
                    self.checkpoint3 = True
            if self.player_x + 25 >= 75 and self.player_x + 25 <= 100:
                if self.player_y - 25 >= 500 and self.player_y - 25 <= 525:
                    self.checkpoint3 = True

        if self.checkpoint1 and self.checkpoint2 and self.checkpoint3:
            strs = "You Win! It took you " + str(self.tries) + str(" times")
            arcade.close_window()
            ctypes.windll.user32.MessageBoxW(0, strs, "Instructions", 1)



    #Used when a key is pressed and changes the variable update it
    def on_key_press(self, symbol, modifiers):
        if symbol == arcade.key.SPACE:
            self.space = True
        if symbol == arcade.key.RIGHT:
            self.right = True
        if symbol == arcade.key.LEFT:
            self.left = True
        if symbol == arcade.key.UP:
            self.up = True
        if symbol == arcade.key.DOWN:
            self.down = True

    #After a key is pressed and the object moves, this resets the key so it only moves once
    def on_key_release(self, symbol, modifiers):
        if symbol == arcade.key.SPACE:
            self.space = False
        if symbol == arcade.key.RIGHT:
            self.right = False
        if symbol == arcade.key.LEFT:
            self.left = False
        if symbol == arcade.key.UP:
            self.up = False
        if symbol == arcade.key.DOWN:
            self.down = False

ctypes.windll.user32.MessageBoxW(0, "Welcome to the World's Hardest Game ", "Welcome", 1)
ctypes.windll.user32.MessageBoxW(0, "You are the green square and your goal is to reach each of the red squares", "Insructions", 1)
ctypes.windll.user32.MessageBoxW(0, "When you reach a red square you must press the spacebar for it to count", "Instructions", 1)
ctypes.windll.user32.MessageBoxW(0, "But if you touch any moving or unmoving obstacles", "Instructions", 1)
ctypes.windll.user32.MessageBoxW(0, "The checkpoints reset and the game starts over", "Instructions", 1)
Game(600, 600, "World's Hardest Game")
arcade.run()
