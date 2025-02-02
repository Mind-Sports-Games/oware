What is it?
===========

An <b>Oware Abapa</b> artificial intelligence game engine.

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/F2F8BR4E0)

Aalina is the strongest mancala playing program out there. It communicates with a Graphical User Interface through an adapted version of the Universal Chess Interface protocol. This mancala engine is thus usually invoked by a GUI, such as [Aualé](https://github.com/joansalasoler/auale), which is the official interface for this engine, but can also be played on the terminal.

![Demo](https://raw.githubusercontent.com/joansalasoler/assets/master/demos/aalina-1.1.gif)

Its features include:
---------------------

* Command line interface
* Plays mancala following the popular Abapa ruleset
* Completely configurable through the UCI protocol
* Includes a set of engine optimization tools

Implementation details:
-----------------------

* Negamax search
* Iterative deepening
* Principal variation search
* Optimized evaluation heuristics
* Minimal perfect hashing of positions
* Endgame tablebases (12 seeds or less)
* Automatically built openings book
* Two-tier transposition table with aging
* Simple time management
* UCT based openings book trainer
* Complete UCI protocol support
* Optional UCT/MCTS search

Command line tools:
-----------------------

* UCI protocol service
* UCI protocol shell interface
* Automatic openings book trainer
* Command line playing interface
* Engine benchmark, perft and divide
* Tournament runner
* Basic tests

The Latest Version
==================

Information on the latest version of this software and its current
development can be found on https://github.com/joansalasoler/oware

Installation
============

Please see the INSTALL file.

Licensing
=========

Please see the COPYING file.
