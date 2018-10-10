# ***Roulette***

This is Java based project simulating game of Roulette as played in most
American casinos.
Class design was created according to OOP principles.
Various types of bets and some common betting 
strategies (with complex algorithms for changing the amount that is used for
each bet in an attempt to recoup losses) are implemented in project.

## **Roulette Description and Rules**

The game of Roulette centers around a wheel with thirty-eight numbered bins. The numbers include 0, 00
(double zero), 1 through 36. There are variety of additional bets, which will be detailed below.
After the bets are placed by the players, the wheel is spun by the house, a small ball is dropped into the
spinning wheel; when the wheel stops spinning, the ball will come to rest in one of the thirty-eight
numbered bins, defining the winning number. The winning number and all of the related winning bets are paid off; the
losing bets are collected. Roulette bets are all paid off using odds, which will be detailed with each of the
bets, below.
The numbers from 1 to 36 are colored red and black in an arbitrary pattern. They fit into various ranges,
as
well as being even or odd, which defines many of the winning bets related to a given number. The
numbers
0 and 00 are colored green, they fit into none of the ranges, and are considered to be neither even nor
odd.
There are relatively few bets related to the zeroes. The geometry of the betting locations on the table
defines
the relationships between number bets.
Available bets:
A “straight bet” is a bet on a single number. There are 38 possible bets, and they pay odds of 35 to 1. Each bin on the wheel pays one of the straight bets.

### Bet types

• A “split bet” is a bet on an adjacent pair of numbers. It pays 17:1. The table layout has the numbers
arranged sequentially in three columns and twelve rows. Adjacent numbers are in the same row or
column. The number 5 is adjacent to 4, 6, 2, 8; the number 1 is adjacent to 2 and 4. There are 114 of
these split bet combinations. Each bin on the wheel pays from two to four of the available split bets.
Any of two bins can make a split bet a winner.

• A “street bet” includes the three numbers in a single row, which pays 11:1. There are twelve of these
bets on the table. A single bin selects one street bet; any of three bins make a street bet a winner.

• A square of four numbers is called a “corner bet” and pays 8:1. There are 72 of these bets available.

• At one end of the layout, it is possible to place a bet on the Five numbers 0, 00, 1, 2 and 3. This pays
6:1. It is the only combination bet that includes 0 or 00.

• A “line bet” is a six number block, which pays 5:1. It is essentially two adjacent street bets. There are
11 such combinations.
Any of the three 12-number ranges (1-12, 13-24, 25-36) pays 2:1. There are just three of these bets.

• The layout offers the three 12-number columns at 2:1 odds. All of the numbers in a given column
have the same remainder when divided by three. Column 1 contains 1, 4, 7, etc., all of which have a
remainder of 1 when divided by 3.

• There are two 18-number ranges: 1-18 is called low, 19-36 is called high. These are called even money
bets because they pay at 1:1 odds.

• The individual numbers are colored red or black in an arbitrary pattern. Note that 0 and 00 are colored
green. The bets on red or black are even money bets, which pay at 1:1 odds.

• The numbers (other than 0 and 00) are also either even or odd. These bets are also even money bets.

### Some Betting Strategies


_Martingale._   The Martingale system starts with a base wagering amount, w, and a count of the number of
losses, c, initially 0. Each loss doubles the bet.
Any given spin will place an amount of w × 2c on a 1:1 proposition (for example, red). When a bet wins,
the loss count is reset to zero; resetting the bet to the base amount, w. This assures that a single win will
recoup all losses. Note that the casinos effectively prevent successful use of this system by imposing a table limit. At a $10
Roulette table, the limit may be as low as $1,000. A Martingale bettor who lost six times in a row would
be facing a $640 bet, and after the seventh loss, their next bet would exceed the table limit. At that point,
the player is unable to recoup all of their losses. Seven losses in a row is only a 1 in 128 probability;
making this a relatively likely situation.

_Waiting._   Another system is to wait until some number of losses have elapsed. For example, wait until
the wheel has spun seven reds in a row, and then bet on black. This can be combined with the Martingale
system to double the bet on each loss as well as waiting for seven reds before betting on black.
This “wait for a favorable state” strategy is based on a confusion between the outcome of each individual
spin and the overall odds of given collections of spins. If the wheel has spun seven reds in a row, it’s
“due”to spin black.

_1-3-2-6 System._   Another betting system is called the 1-3-2-6 system. The idea is to avoid the doubling
of the bet at each loss and running into the table limit. Rather than attempt to recoup all losses in a single
win, this system looks to recoup all losses by waiting for four wins in a row.
The sequence of numbers (1, 3, 2 and 6) are the multipliers to use when placing bets after winning. At
each loss, the sequence resets to the multiplier of 1. At each win, the multiplier is advanced through the
sequence. After one win, the bet is now 3w. After a second win, the bet is reduced to 2w, and the winnings of 4w are
“taken down” or removed from play. In the event of a third win, the bet is advanced to 6w. Should there
be a fourth win, the player has doubled their money, and the sequence resets.

_Cancellation._   Another method for tracking the lost bets is called the Cancellation system or the Labouchere system. The player starts with a betting budget allocated as a series of numbers. The usual example is 1, 2, 3, 4, 5, 6, 7, 8, 9.
Each bet is sum of the first and last numbers in the last. In this case 1+9 is 10.

## **Getting Started**

Run: _src\main\java\game\GameManager.java_.
You will be asked to enter information for Person Player
and number of auto Robot Players. Then you will be asked to choose the rates.

## **Running the tests**

Few JUnit tests are in _src\test\java_.


Author: _Sorokin Anton_
