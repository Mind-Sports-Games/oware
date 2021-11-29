package com.joansala.game.chess;

/*
 * Aalina engine.
 * Copyright (c) 2021 Joan Sala Soler <contact@joansala.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import picocli.CommandLine.Command;

import com.joansala.cli.*;
import com.joansala.engine.*;
import com.joansala.engine.base.BaseModule;
import com.joansala.engine.negamax.Negamax;
import com.joansala.cache.GameCache;


/**
 * Binds together the components of the Chess engine.
 */
public class ChessModule extends BaseModule {

    /**
     * Command line interface.
     */
    @Command(
      name = "chess",
      version = "1.0.0",
      description = "Chess is an abstract strategy board game"
    )
    private static class ChessCommand extends MainCommand {}


    /**
     * Game module configuration.
     */
    @Override protected void configure() {
        bind(Game.class).to(ChessGame.class);
        bind(Board.class).to(ChessBoard.class);
        bind(Engine.class).to(Negamax.class);
        bind(Cache.class).to(GameCache.class);
        bind(Roots.class).to(ChessRoots.class);
    }


    /**
     * Exectues the command line interface.
     *
     * @param args      Command line parameters
     */
    public static void main(String[] args) throws Exception {
        BaseModule module = new ChessModule();
        ChessCommand main = new ChessCommand();
        System.exit(main.execute(module, args));
    }
}
