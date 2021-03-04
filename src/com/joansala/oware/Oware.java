package com.joansala.oware;

/*
 * Aalina oware engine.
 * Copyright (c) 2014-2021 Joan Sala Soler <contact@joansala.com>
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


/**
 * Definitions for the Oware Abapa game.
 *
 * @author    Joan Sala Soler
 * @version   1.0.0
 */
final class Oware {

    /** Number of pits on the board */
    static final int BOARD_SIZE = 12;

    /** Number of seeds on the board */
    static final int SEED_COUNT = 48;

    /** Number of seeds to surpass to win */
    static final int SEED_GOAL = 24;

    /** Leftmost player house from south's perspective */
    static final int SOUTH_LEFT = 0;

    /** Rightmost player house from south's perspective */
    static final int SOUTH_RIGHT = 5;

    /** Store house for south */
    static final int SOUTH_STORE = 12;

    /** Leftmost player house from north's perspective */
    static final int NORTH_LEFT = 6;

    /** Rightmost player house from north's perspective */
    static final int NORTH_RIGHT = 11;

    /** Store house for north */
    static final int NORTH_STORE = 13;

    /** South houses bitmask */
    static final int SOUTH_MASK = 0b000000111111;

    /** North houses bitmask */
    static final int NORTH_MASK = 0b111111000000;

    /** Default start position */
    static final int[] START_POSITION = {
        4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0
    };

    /** Used to determine the pit where a seeding lands. Helps in
        determining when a move could be a capture */
    static final int[][] REAPER = {
        {-1, -1, -1, -1, -1, -1,  6,  7,  8,  9, 10, 11,
         -1, -1, -1, -1, -1,  6,  7,  8,  9, 10, 11, -1,
         -1, -1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1,  6,  7,  8,  9, 10, 11, -1,
         -1, -1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1,
         -1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1,
         -1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1,
         -1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1,
         -1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1,
         -1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1,
         -1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1, -1,
          6,  7,  8,  9, 10, 11, -1, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1,  6,  7,  8,  9, 10, 11, -1, -1, -1, -1, -1,
          6,  7,  8,  9, 10, 11, -1, -1, -1, -1, -1,  6,
          7,  8,  9, 10, 11, -1, -1, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1,  0,  1,  2,  3,  4,  5,
         -1, -1, -1, -1, -1,  0,  1,  2,  3,  4,  5, -1,
         -1, -1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1,  0,  1,  2,  3,  4,  5, -1,
         -1, -1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1,
         -1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1,
         -1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1,
         -1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1,
         -1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1,
         -1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1,
         -1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1, -1,
          0,  1,  2,  3,  4,  5, -1, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1,  0,  1,  2,  3,  4,  5, -1, -1, -1, -1, -1,
          0,  1,  2,  3,  4,  5, -1, -1, -1, -1, -1,  0,
          1,  2,  3,  4,  5, -1, -1, -1, -1, -1, -1, -1,
         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
    };

    /** Hash sign for positions were south is to move */
    static final long SOUTH_SIGN = 0x80000000000L;

    /** Hash sign for positions were north is to move */
    static final long NORTH_SIGN = 0x00000000000L;

    /** Binomial coefficients used to compute hash codes */
    static final long[][] COEFFICIENTS = {
        { 0x00000000030L, 0x00000000498L, 0x00000004C90L, 0x0000003D02CL,
          0x0000027A830L, 0x000015E4DA8L, 0x0000A8E5710L, 0x0004892968EL,
          0x001C3901A90L, 0x00A0DE89768L, 0x035038492B0L, 0x104A6A1268CL,
          0x4B3010F2810L },
        { 0x0000000002FL, 0x00000000468L, 0x000000047F8L, 0x0000003839CL,
          0x0000023D804L, 0x0000136A578L, 0x00009300968L, 0x0003E043F7EL,
          0x0017AFD8402L, 0x0084A587CD8L, 0x02AF59BFB48L, 0x0CFA31C93DCL,
          0x3AE5A6E0184L },
        { 0x0000000002EL, 0x00000000439L, 0x00000004390L, 0x00000033BA4L,
          0x00000205468L, 0x0000112CD74L, 0x00007F963F0L, 0x00034D43616L,
          0x0013CF94484L, 0x006CF5AF8D6L, 0x022AB437E70L, 0x0A4AD809894L,
          0x2DEB7516DA8L },
        { 0x0000000002DL, 0x0000000040BL, 0x00000003F57L, 0x0000002F814L,
          0x000001D18C4L, 0x00000F2790CL, 0x00006E6967CL, 0x0002CDAD226L,
          0x00108250E6EL, 0x0059261B452L, 0x01BDBE8859AL, 0x082023D1A24L,
          0x23A09D0D514L },
        { 0x0000000002CL, 0x000000003DEL, 0x00000003B4CL, 0x0000002B8BDL,
          0x000001A20B0L, 0x00000D56048L, 0x00005F41D70L, 0x00025F43BAAL,
          0x000DB4A3C48L, 0x0048A3CA5E4L, 0x0164986D148L, 0x0662654948AL,
          0x1B80793BAF0L },
        { 0x0000000002BL, 0x000000003B2L, 0x0000000376EL, 0x00000027D71L,
          0x000001767F3L, 0x00000BB3F98L, 0x000051EBD28L, 0x00020001E3AL,
          0x000B556009EL, 0x003AEF2699CL, 0x011BF4A2B64L, 0x04FDCCDC342L,
          0x151E13F2666L },
        { 0x0000000002AL, 0x00000000387L, 0x000000033BCL, 0x00000024603L,
          0x0000014EA82L, 0x00000A3D7A5L, 0x00004637D90L, 0x0001AE16112L,
          0x0009555E264L, 0x002F99C68FEL, 0x00E1057C1C8L, 0x03E1D8397DEL,
          0x10204716324L },
        { 0x00000000029L, 0x0000000035DL, 0x00000003035L, 0x00000021247L,
          0x0000012A47FL, 0x000008EED23L, 0x00003BFA5EBL, 0x000167DE382L,
          0x0007A748152L, 0x0026446869AL, 0x00B16BB58CAL, 0x0300D2BD616L,
          0x0C3E6EDCB46L },
        { 0x00000000028L, 0x00000000334L, 0x00000002CD8L, 0x0000001E212L,
          0x00000109238L, 0x000007C48A4L, 0x0000330B8C8L, 0x00012BE3D97L,
          0x00063F69DD0L, 0x001E9D20548L, 0x008B274D230L, 0x024F6707D4CL,
          0x093D9C1F530L },
        { 0x00000000027L, 0x0000000030CL, 0x000000029A4L, 0x0000001B53AL,
          0x000000EB026L, 0x000006BB66CL, 0x00002B47024L, 0x0000F8D84CFL,
          0x00051386039L, 0x00185DB6778L, 0x006C8A2CCE8L, 0x01C43FBAB1CL,
          0x06EE35177E4L },
        { 0x00000000026L, 0x000000002E5L, 0x00000002698L, 0x00000018B96L,
          0x000000CFAECL, 0x000005D0646L, 0x0000248B9B8L, 0x0000CD914ABL,
          0x00041AADB6AL, 0x00134A3073FL, 0x00542C76570L, 0x0157B58DE34L,
          0x0529F55CCC8L },
        { 0x00000000025L, 0x000000002BFL, 0x000000023B3L, 0x000000164FEL,
          0x000000B6F56L, 0x00000500B5AL, 0x00001EBB372L, 0x0000A905AF3L,
          0x00034D1C6BFL, 0x000F2F82BD5L, 0x0040E245E31L, 0x010389178C4L,
          0x03D23FCEE94L },
        { 0x00000000024L, 0x0000000029AL, 0x000000020F4L, 0x0000001414BL,
          0x000000A0A58L, 0x00000449C04L, 0x000019BA818L, 0x00008A4A781L,
          0x0002A416BCCL, 0x000BE266516L, 0x0031B2C325CL, 0x00C2A6D1A93L,
          0x02CEB6B75D0L },
        { 0x00000000023L, 0x00000000276L, 0x00000001E5AL, 0x00000012057L,
          0x0000008C90DL, 0x000003A91ACL, 0x00001570C14L, 0x0000708FF69L,
          0x000219CC44BL, 0x00093E4F94AL, 0x0025D05CD46L, 0x0090F40E837L,
          0x020C0FE5B3DL },
        { 0x00000000022L, 0x00000000253L, 0x00000001BE4L, 0x000000101FDL,
          0x0000007A8B6L, 0x0000031C89FL, 0x000011C7A68L, 0x00005B1F355L,
          0x0001A93C4E2L, 0x000724834FFL, 0x001C920D3FCL, 0x006B23B1AF1L,
          0x017B1BD7306L },
        { 0x00000000021L, 0x00000000231L, 0x00000001991L, 0x0000000E619L,
          0x0000006A6B9L, 0x000002A1FE9L, 0x00000EAB1C9L, 0x000049578EDL,
          0x00014E1D18DL, 0x00057B4701DL, 0x00156D89EFDL, 0x004E91A46F5L,
          0x010FF825815L },
        { 0x00000000020L, 0x00000000210L, 0x00000001760L, 0x0000000CC88L,
          0x0000005C0A0L, 0x00000237930L, 0x00000C091E0L, 0x00003AAC724L,
          0x000104C58A0L, 0x00042D29E90L, 0x000FF242EE0L, 0x0039241A7F8L,
          0x00C16681120L },
        { 0x0000000001FL, 0x000000001F0L, 0x00000001550L, 0x0000000B528L,
          0x0000004F418L, 0x000001DB890L, 0x000009D18B0L, 0x00002EA3544L,
          0x0000CA1917CL, 0x000328645F0L, 0x000BC519050L, 0x002931D7918L,
          0x00884266928L },
        { 0x0000000001EL, 0x000000001D1L, 0x00000001360L, 0x00000009FD8L,
          0x00000043EF0L, 0x0000018C478L, 0x000007F6020L, 0x000024D1C94L,
          0x00009B75C38L, 0x00025E4B474L, 0x00089CB4A60L, 0x001D6CBE8C8L,
          0x005F108F010L },
        { 0x0000000001DL, 0x000000001B3L, 0x0000000118FL, 0x00000008C78L,
          0x00000039F18L, 0x00000148588L, 0x00000669BA8L, 0x00001CDBC74L,
          0x000076A3FA4L, 0x0001C2D583CL, 0x00063E695ECL, 0x0014D009E68L,
          0x0041A3D0748L },
        { 0x0000000001CL, 0x00000000196L, 0x00000000FDCL, 0x00000007AE9L,
          0x000000312A0L, 0x0000010E670L, 0x00000521620L, 0x000016720CCL,
          0x000059C8330L, 0x00014C31898L, 0x00047B93DB0L, 0x000E91A087CL,
          0x002CD3C68E0L },
        { 0x0000000001BL, 0x0000000017AL, 0x00000000E46L, 0x00000006B0DL,
          0x000000297B7L, 0x000000DD3D0L, 0x00000412FB0L, 0x00001150AACL,
          0x00004356264L, 0x0000F269568L, 0x00032F62518L, 0x000A160CACCL,
          0x001E4226064L },
        { 0x0000000001AL, 0x0000000015FL, 0x00000000CCCL, 0x00000005CC7L,
          0x00000022CAAL, 0x000000B3C19L, 0x00000335BE0L, 0x00000D3DAFCL,
          0x000032057B8L, 0x0000AF13304L, 0x00023CF8FB0L, 0x0006E6AA5B4L,
          0x00142C19598L },
        { 0x00000000019L, 0x00000000145L, 0x00000000B6DL, 0x00000004FFBL,
          0x0000001CFE3L, 0x00000090F6FL, 0x00000281FC7L, 0x00000A07F1CL,
          0x000024C7CBCL, 0x00007D0DB4CL, 0x00018DE5CACL, 0x0004A9B1604L,
          0x000D456EFE4L },
        { 0x00000000018L, 0x0000000012CL, 0x00000000A28L, 0x0000000448EL,
          0x00000017FE8L, 0x00000073F8CL, 0x000001F1058L, 0x00000785F55L,
          0x00001ABFDA0L, 0x00005845E90L, 0x000110D8160L, 0x00031BCB958L,
          0x00089BBD9E0L },
        { 0x00000000017L, 0x00000000114L, 0x000000008FCL, 0x00000003A66L,
          0x00000013B5AL, 0x0000005BFA4L, 0x0000017D0CCL, 0x00000594EFDL,
          0x00001339E4BL, 0x00003D860F0L, 0x0000B8922D0L, 0x00020AF37F8L,
          0x00057FF2088L },
        { 0x00000000016L, 0x000000000FDL, 0x000000007E8L, 0x0000000316AL,
          0x000000100F4L, 0x0000004844AL, 0x00000121128L, 0x00000417E31L,
          0x00000DA4F4EL, 0x00002A4C2A5L, 0x00007B0C1E0L, 0x00015261528L,
          0x000374FE890L },
        { 0x00000000015L, 0x000000000E7L, 0x000000006EBL, 0x00000002982L,
          0x0000000CF8AL, 0x00000038356L, 0x000000D8CDEL, 0x000002F6D09L,
          0x0000098D11DL, 0x00001CA7357L, 0x000050BFF3BL, 0x0000D755348L,
          0x0002229D368L },
        { 0x00000000014L, 0x000000000D2L, 0x00000000604L, 0x00000002297L,
          0x0000000A608L, 0x0000002B3CCL, 0x000000A0988L, 0x0000021E02BL,
          0x00000696414L, 0x0000131A23AL, 0x00003418BE4L, 0x0000869540DL,
          0x00014B48020L },
        { 0x00000000013L, 0x000000000BEL, 0x00000000532L, 0x00000001C93L,
          0x00000008371L, 0x00000020DC4L, 0x000000755BCL, 0x0000017D6A3L,
          0x000004783E9L, 0x00000C83E26L, 0x000020FE9AAL, 0x0000527C829L,
          0x0000C4B2C13L },
        { 0x00000000012L, 0x000000000ABL, 0x00000000474L, 0x00000001761L,
          0x000000066DEL, 0x00000018A53L, 0x000000547F8L, 0x000001080E7L,
          0x000002FAD46L, 0x0000080BA3DL, 0x0000147AB84L, 0x0000317DE7FL,
          0x000072363EAL },
        { 0x00000000011L, 0x00000000099L, 0x000000003C9L, 0x000000012EDL,
          0x00000004F7DL, 0x00000012375L, 0x0000003BDA5L, 0x000000B38EFL,
          0x000001F2C5FL, 0x00000510CF7L, 0x00000C6F147L, 0x00001D032FBL,
          0x000040B856BL },
        { 0x00000000010L, 0x00000000088L, 0x00000000330L, 0x00000000F24L,
          0x00000003C90L, 0x0000000D3F8L, 0x00000029A30L, 0x00000077B4AL,
          0x0000013F370L, 0x0000031E098L, 0x0000075E450L, 0x000010941B4L,
          0x000023B5270L },
        { 0x0000000000FL, 0x00000000078L, 0x000000002A8L, 0x00000000BF4L,
          0x00000002D6CL, 0x00000009768L, 0x0000001C638L, 0x0000004E11AL,
          0x000000C7826L, 0x000001DED28L, 0x000004403B8L, 0x00000935D64L,
          0x000013210BCL },
        { 0x0000000000EL, 0x00000000069L, 0x00000000230L, 0x0000000094CL,
          0x00000002178L, 0x000000069FCL, 0x00000012ED0L, 0x00000031AE2L,
          0x0000007970CL, 0x00000117502L, 0x00000261690L, 0x000004F59ACL,
          0x000009EB358L },
        { 0x0000000000DL, 0x0000000005BL, 0x000000001C7L, 0x0000000071CL,
          0x0000000182CL, 0x00000004884L, 0x0000000C4D4L, 0x0000001EC12L,
          0x00000047C2AL, 0x0000009DDF6L, 0x0000014A18EL, 0x0000029431CL,
          0x000004F59ACL },
        { 0x0000000000CL, 0x0000000004EL, 0x0000000016CL, 0x00000000555L,
          0x00000001110L, 0x00000003058L, 0x00000007C50L, 0x0000001273EL,
          0x00000029018L, 0x000000561CCL, 0x000000AC398L, 0x0000014A18EL,
          0x00000261690L },
        { 0x0000000000BL, 0x00000000042L, 0x0000000011EL, 0x000000003E9L,
          0x00000000BBBL, 0x00000001F48L, 0x00000004BF8L, 0x0000000AAEEL,
          0x000000168DAL, 0x0000002D1B4L, 0x000000561CCL, 0x0000009DDF6L,
          0x00000117502L },
        { 0x0000000000AL, 0x00000000037L, 0x000000000DCL, 0x000000002CBL,
          0x000000007D2L, 0x0000000138DL, 0x00000002CB0L, 0x00000005EF6L,
          0x0000000BDECL, 0x000000168DAL, 0x00000029018L, 0x00000047C2AL,
          0x0000007970CL },
        { 0x00000000009L, 0x0000000002DL, 0x000000000A5L, 0x000000001EFL,
          0x00000000507L, 0x00000000BBBL, 0x00000001923L, 0x00000003246L,
          0x00000005EF6L, 0x0000000AAEEL, 0x0000001273EL, 0x0000001EC12L,
          0x00000031AE2L },
        { 0x00000000008L, 0x00000000024L, 0x00000000078L, 0x0000000014AL,
          0x00000000318L, 0x000000006B4L, 0x00000000D68L, 0x00000001923L,
          0x00000002CB0L, 0x00000004BF8L, 0x00000007C50L, 0x0000000C4D4L,
          0x00000012ED0L },
        { 0x00000000007L, 0x0000000001CL, 0x00000000054L, 0x000000000D2L,
          0x000000001CEL, 0x0000000039CL, 0x000000006B4L, 0x00000000BBBL,
          0x0000000138DL, 0x00000001F48L, 0x00000003058L, 0x00000004884L,
          0x000000069FCL },
        { 0x00000000006L, 0x00000000015L, 0x00000000038L, 0x0000000007EL,
          0x000000000FCL, 0x000000001CEL, 0x00000000318L, 0x00000000507L,
          0x000000007D2L, 0x00000000BBBL, 0x00000001110L, 0x0000000182CL,
          0x00000002178L },
        { 0x00000000005L, 0x0000000000FL, 0x00000000023L, 0x00000000046L,
          0x0000000007EL, 0x000000000D2L, 0x0000000014AL, 0x000000001EFL,
          0x000000002CBL, 0x000000003E9L, 0x00000000555L, 0x0000000071CL,
          0x0000000094CL },
        { 0x00000000004L, 0x0000000000AL, 0x00000000014L, 0x00000000023L,
          0x00000000038L, 0x00000000054L, 0x00000000078L, 0x000000000A5L,
          0x000000000DCL, 0x0000000011EL, 0x0000000016CL, 0x000000001C7L,
          0x00000000230L },
        { 0x00000000003L, 0x00000000006L, 0x0000000000AL, 0x0000000000FL,
          0x00000000015L, 0x0000000001CL, 0x00000000024L, 0x0000000002DL,
          0x00000000037L, 0x00000000042L, 0x0000000004EL, 0x0000000005BL,
          0x00000000069L },
        { 0x00000000002L, 0x00000000003L, 0x00000000004L, 0x00000000005L,
          0x00000000006L, 0x00000000007L, 0x00000000008L, 0x00000000009L,
          0x0000000000AL, 0x0000000000BL, 0x0000000000CL, 0x0000000000DL,
          0x0000000000EL },
        { 0x00000000001L, 0x00000000001L, 0x00000000001L, 0x00000000001L,
          0x00000000001L, 0x00000000001L, 0x00000000001L, 0x00000000001L,
          0x00000000001L, 0x00000000001L, 0x00000000001L, 0x00000000001L,
          0x00000000001L }
    };
}
