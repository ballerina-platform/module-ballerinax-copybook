// Generated from CopyBook.g4 by ANTLR 4.13.1
package io.ballerina.lib.schema;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CopyBookParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALL=1, ARE=2, ASCENDING=3, BINARY=4, BIT=5, BLANK=6, BY=7, CHANNEL=8, 
		CHARACTER=9, COBOL=10, COMP=11, COMP_1=12, COMP_2=13, COMP_3=14, COMP_4=15, 
		COMP_5=16, COMPUTATIONAL=17, COMPUTATIONAL_1=18, COMPUTATIONAL_2=19, COMPUTATIONAL_3=20, 
		COMPUTATIONAL_4=21, COMPUTATIONAL_5=22, CONTROL_POINT=23, DATA=24, DATE=25, 
		DEPENDING=26, DESCENDING=27, DFHRESP=28, DFHVALUE=29, DISPLAY=30, DISPLAY_1=31, 
		DOUBLE=32, EVENT=33, EXTENDED=34, EXTERNAL=35, FALSE=36, FILLER=37, FULL=38, 
		FUNCTION_POINTER=39, GLOBAL=40, HIGH_VALUE=41, HIGH_VALUES=42, INDEX=43, 
		INDEXED=44, INTEGER=45, IS=46, JUST=47, JUSTIFIED=48, KANJI=49, KEY=50, 
		LEADING=51, LEFT=52, LINE=53, LOCAL=54, LOCK=55, LOW_VALUE=56, LOW_VALUES=57, 
		NATIONAL=58, NULL_=59, NULLS=60, OCCURS=61, OF=62, ON=63, PACKED_DECIMAL=64, 
		PIC=65, PICTURE=66, POINTER=67, PROCEDURE_POINTER=68, QUOTE=69, QUOTES=70, 
		REAL=71, REDEFINES=72, RENAMES=73, RIGHT=74, SEPARATE=75, SIGN=76, SPACE=77, 
		SPACES=78, STOP=79, STRING=80, SYNC=81, SYNCHRONIZED=82, TASK=83, THROUGH=84, 
		THRU=85, TIMES=86, TO=87, TRAILING=88, TRUE=89, TRUNCATED=90, TYPE=91, 
		USAGE=92, VALUE=93, VALUES=94, WHEN=95, WITH=96, ZERO=97, ZEROS=98, ZEROES=99, 
		ASTERISKCHAR=100, DOUBLEASTERISKCHAR=101, COLONCHAR=102, COMMACHAR=103, 
		DOLLARCHAR=104, DOT_FS=105, DOT=106, LESSTHANCHAR=107, LPARENCHAR=108, 
		MINUSCHAR=109, MORETHANCHAR=110, PLUSCHAR=111, RPARENCHAR=112, SLASHCHAR=113, 
		NONNUMERICLITERAL=114, LEVEL_NUMBER_66=115, LEVEL_NUMBER_77=116, LEVEL_NUMBER_88=117, 
		INTEGERLITERAL=118, NUMERICLITERAL=119, IDENTIFIER=120, NEWLINE=121, WS=122, 
		COMMENT=123;
	public static final int
		RULE_startRule = 0, RULE_dataDescription = 1, RULE_dataDescriptionEntry = 2, 
		RULE_dataDescriptionEntryFormat1 = 3, RULE_dataDescriptionEntryClauses = 4, 
		RULE_dataDescriptionEntryFormat2 = 5, RULE_dataDescriptionEntryFormat3 = 6, 
		RULE_dataBlankWhenZeroClause = 7, RULE_dataExternalClause = 8, RULE_dataGlobalClause = 9, 
		RULE_dataJustifiedClause = 10, RULE_dataOccursClause = 11, RULE_dataOccursTo = 12, 
		RULE_dataOccursSort = 13, RULE_dataPictureClause = 14, RULE_pictureString = 15, 
		RULE_pictureChars = 16, RULE_pictureCardinality = 17, RULE_dataRedefinesClause = 18, 
		RULE_dataRenamesClause = 19, RULE_dataSignClause = 20, RULE_dataSynchronizedClause = 21, 
		RULE_dataUsageClause = 22, RULE_dataValueClause = 23, RULE_dataValueInterval = 24, 
		RULE_dataValueIntervalFrom = 25, RULE_dataValueIntervalTo = 26, RULE_identifier = 27, 
		RULE_qualifiedDataName = 28, RULE_conditionName = 29, RULE_dataName = 30, 
		RULE_indexName = 31, RULE_cobolWord = 32, RULE_literal = 33, RULE_booleanLiteral = 34, 
		RULE_numericLiteral = 35, RULE_integerLiteral = 36, RULE_cicsDfhRespLiteral = 37, 
		RULE_cicsDfhValueLiteral = 38, RULE_figurativeConstant = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"startRule", "dataDescription", "dataDescriptionEntry", "dataDescriptionEntryFormat1", 
			"dataDescriptionEntryClauses", "dataDescriptionEntryFormat2", "dataDescriptionEntryFormat3", 
			"dataBlankWhenZeroClause", "dataExternalClause", "dataGlobalClause", 
			"dataJustifiedClause", "dataOccursClause", "dataOccursTo", "dataOccursSort", 
			"dataPictureClause", "pictureString", "pictureChars", "pictureCardinality", 
			"dataRedefinesClause", "dataRenamesClause", "dataSignClause", "dataSynchronizedClause", 
			"dataUsageClause", "dataValueClause", "dataValueInterval", "dataValueIntervalFrom", 
			"dataValueIntervalTo", "identifier", "qualifiedDataName", "conditionName", 
			"dataName", "indexName", "cobolWord", "literal", "booleanLiteral", "numericLiteral", 
			"integerLiteral", "cicsDfhRespLiteral", "cicsDfhValueLiteral", "figurativeConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'*'", "'**'", "':'", "','", "'$'", null, "'.'", 
			"'<'", "'('", "'-'", "'>'", "'+'", "')'", "'/'", null, "'66'", "'77'", 
			"'88'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALL", "ARE", "ASCENDING", "BINARY", "BIT", "BLANK", "BY", "CHANNEL", 
			"CHARACTER", "COBOL", "COMP", "COMP_1", "COMP_2", "COMP_3", "COMP_4", 
			"COMP_5", "COMPUTATIONAL", "COMPUTATIONAL_1", "COMPUTATIONAL_2", "COMPUTATIONAL_3", 
			"COMPUTATIONAL_4", "COMPUTATIONAL_5", "CONTROL_POINT", "DATA", "DATE", 
			"DEPENDING", "DESCENDING", "DFHRESP", "DFHVALUE", "DISPLAY", "DISPLAY_1", 
			"DOUBLE", "EVENT", "EXTENDED", "EXTERNAL", "FALSE", "FILLER", "FULL", 
			"FUNCTION_POINTER", "GLOBAL", "HIGH_VALUE", "HIGH_VALUES", "INDEX", "INDEXED", 
			"INTEGER", "IS", "JUST", "JUSTIFIED", "KANJI", "KEY", "LEADING", "LEFT", 
			"LINE", "LOCAL", "LOCK", "LOW_VALUE", "LOW_VALUES", "NATIONAL", "NULL_", 
			"NULLS", "OCCURS", "OF", "ON", "PACKED_DECIMAL", "PIC", "PICTURE", "POINTER", 
			"PROCEDURE_POINTER", "QUOTE", "QUOTES", "REAL", "REDEFINES", "RENAMES", 
			"RIGHT", "SEPARATE", "SIGN", "SPACE", "SPACES", "STOP", "STRING", "SYNC", 
			"SYNCHRONIZED", "TASK", "THROUGH", "THRU", "TIMES", "TO", "TRAILING", 
			"TRUE", "TRUNCATED", "TYPE", "USAGE", "VALUE", "VALUES", "WHEN", "WITH", 
			"ZERO", "ZEROS", "ZEROES", "ASTERISKCHAR", "DOUBLEASTERISKCHAR", "COLONCHAR", 
			"COMMACHAR", "DOLLARCHAR", "DOT_FS", "DOT", "LESSTHANCHAR", "LPARENCHAR", 
			"MINUSCHAR", "MORETHANCHAR", "PLUSCHAR", "RPARENCHAR", "SLASHCHAR", "NONNUMERICLITERAL", 
			"LEVEL_NUMBER_66", "LEVEL_NUMBER_77", "LEVEL_NUMBER_88", "INTEGERLITERAL", 
			"NUMERICLITERAL", "IDENTIFIER", "NEWLINE", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CopyBook.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    int redefinesUsed = 0;
	    int blankWhenZeroUsed = 0;
	    int externalUsed = 0;
	    int globalUsed = 0;
	    int justifiedUsed = 0;
	    int occursUsed = 0;
	    int pictureUsed = 0;
	    int signUsed = 0;
	    int synchronizedUsed = 0;
	    int usageUsed = 0;
	    int dataValueUsed = 0;

	public CopyBookParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartRuleContext extends ParserRuleContext {
		public DataDescriptionContext dataDescription() {
			return getRuleContext(DataDescriptionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CopyBookParser.EOF, 0); }
		public StartRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitStartRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartRuleContext startRule() throws RecognitionException {
		StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			dataDescription();
			setState(81);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionContext extends ParserRuleContext {
		public List<DataDescriptionEntryContext> dataDescriptionEntry() {
			return getRuleContexts(DataDescriptionEntryContext.class);
		}
		public DataDescriptionEntryContext dataDescriptionEntry(int i) {
			return getRuleContext(DataDescriptionEntryContext.class,i);
		}
		public DataDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescription; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionContext dataDescription() throws RecognitionException {
		DataDescriptionContext _localctx = new DataDescriptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dataDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				dataDescriptionEntry();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 271L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionEntryContext extends ParserRuleContext {
		public DataDescriptionEntryFormat1Context dataDescriptionEntryFormat1() {
			return getRuleContext(DataDescriptionEntryFormat1Context.class,0);
		}
		public DataDescriptionEntryFormat2Context dataDescriptionEntryFormat2() {
			return getRuleContext(DataDescriptionEntryFormat2Context.class,0);
		}
		public DataDescriptionEntryFormat3Context dataDescriptionEntryFormat3() {
			return getRuleContext(DataDescriptionEntryFormat3Context.class,0);
		}
		public TerminalNode COMMENT() { return getToken(CopyBookParser.COMMENT, 0); }
		public DataDescriptionEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescriptionEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescriptionEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionEntryContext dataDescriptionEntry() throws RecognitionException {
		DataDescriptionEntryContext _localctx = new DataDescriptionEntryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dataDescriptionEntry);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEVEL_NUMBER_77:
			case INTEGERLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				dataDescriptionEntryFormat1();
				}
				break;
			case LEVEL_NUMBER_66:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				dataDescriptionEntryFormat2();
				}
				break;
			case LEVEL_NUMBER_88:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				dataDescriptionEntryFormat3();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				match(COMMENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionEntryFormat1Context extends ParserRuleContext {
		public DataDescriptionEntryClausesContext dataDescriptionEntryClauses() {
			return getRuleContext(DataDescriptionEntryClausesContext.class,0);
		}
		public TerminalNode DOT_FS() { return getToken(CopyBookParser.DOT_FS, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(CopyBookParser.INTEGERLITERAL, 0); }
		public TerminalNode LEVEL_NUMBER_77() { return getToken(CopyBookParser.LEVEL_NUMBER_77, 0); }
		public TerminalNode FILLER() { return getToken(CopyBookParser.FILLER, 0); }
		public DataNameContext dataName() {
			return getRuleContext(DataNameContext.class,0);
		}
		public DataDescriptionEntryFormat1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescriptionEntryFormat1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescriptionEntryFormat1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionEntryFormat1Context dataDescriptionEntryFormat1() throws RecognitionException {
		DataDescriptionEntryFormat1Context _localctx = new DataDescriptionEntryFormat1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_dataDescriptionEntryFormat1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !(_la==LEVEL_NUMBER_77 || _la==INTEGERLITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(95);
				match(FILLER);
				}
				break;
			case 2:
				{
				setState(96);
				dataName();
				}
				break;
			}
			setState(99);
			dataDescriptionEntryClauses();
			setState(100);
			match(DOT_FS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionEntryClausesContext extends ParserRuleContext {
		public List<DataRedefinesClauseContext> dataRedefinesClause() {
			return getRuleContexts(DataRedefinesClauseContext.class);
		}
		public DataRedefinesClauseContext dataRedefinesClause(int i) {
			return getRuleContext(DataRedefinesClauseContext.class,i);
		}
		public List<DataExternalClauseContext> dataExternalClause() {
			return getRuleContexts(DataExternalClauseContext.class);
		}
		public DataExternalClauseContext dataExternalClause(int i) {
			return getRuleContext(DataExternalClauseContext.class,i);
		}
		public List<DataGlobalClauseContext> dataGlobalClause() {
			return getRuleContexts(DataGlobalClauseContext.class);
		}
		public DataGlobalClauseContext dataGlobalClause(int i) {
			return getRuleContext(DataGlobalClauseContext.class,i);
		}
		public List<DataPictureClauseContext> dataPictureClause() {
			return getRuleContexts(DataPictureClauseContext.class);
		}
		public DataPictureClauseContext dataPictureClause(int i) {
			return getRuleContext(DataPictureClauseContext.class,i);
		}
		public List<DataUsageClauseContext> dataUsageClause() {
			return getRuleContexts(DataUsageClauseContext.class);
		}
		public DataUsageClauseContext dataUsageClause(int i) {
			return getRuleContext(DataUsageClauseContext.class,i);
		}
		public List<DataValueClauseContext> dataValueClause() {
			return getRuleContexts(DataValueClauseContext.class);
		}
		public DataValueClauseContext dataValueClause(int i) {
			return getRuleContext(DataValueClauseContext.class,i);
		}
		public List<DataOccursClauseContext> dataOccursClause() {
			return getRuleContexts(DataOccursClauseContext.class);
		}
		public DataOccursClauseContext dataOccursClause(int i) {
			return getRuleContext(DataOccursClauseContext.class,i);
		}
		public List<DataSignClauseContext> dataSignClause() {
			return getRuleContexts(DataSignClauseContext.class);
		}
		public DataSignClauseContext dataSignClause(int i) {
			return getRuleContext(DataSignClauseContext.class,i);
		}
		public List<DataSynchronizedClauseContext> dataSynchronizedClause() {
			return getRuleContexts(DataSynchronizedClauseContext.class);
		}
		public DataSynchronizedClauseContext dataSynchronizedClause(int i) {
			return getRuleContext(DataSynchronizedClauseContext.class,i);
		}
		public List<DataJustifiedClauseContext> dataJustifiedClause() {
			return getRuleContexts(DataJustifiedClauseContext.class);
		}
		public DataJustifiedClauseContext dataJustifiedClause(int i) {
			return getRuleContext(DataJustifiedClauseContext.class,i);
		}
		public List<DataBlankWhenZeroClauseContext> dataBlankWhenZeroClause() {
			return getRuleContexts(DataBlankWhenZeroClauseContext.class);
		}
		public DataBlankWhenZeroClauseContext dataBlankWhenZeroClause(int i) {
			return getRuleContext(DataBlankWhenZeroClauseContext.class,i);
		}
		public DataDescriptionEntryClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescriptionEntryClauses; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescriptionEntryClauses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionEntryClausesContext dataDescriptionEntryClauses() throws RecognitionException {
		DataDescriptionEntryClausesContext _localctx = new DataDescriptionEntryClausesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataDescriptionEntryClauses);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(102);
						if (!(redefinesUsed == 0)) throw new FailedPredicateException(this, "redefinesUsed == 0");
						setState(103);
						dataRedefinesClause();
						redefinesUsed++;
						}
						break;
					case 2:
						{
						setState(106);
						if (!(externalUsed == 0)) throw new FailedPredicateException(this, "externalUsed == 0");
						setState(107);
						dataExternalClause();
						externalUsed++;
						}
						break;
					case 3:
						{
						setState(110);
						if (!(globalUsed == 0)) throw new FailedPredicateException(this, "globalUsed == 0");
						setState(111);
						dataGlobalClause();
						globalUsed++;
						}
						break;
					case 4:
						{
						setState(114);
						if (!(pictureUsed == 0)) throw new FailedPredicateException(this, "pictureUsed == 0");
						setState(115);
						dataPictureClause();
						pictureUsed++;
						}
						break;
					case 5:
						{
						setState(118);
						if (!(usageUsed == 0)) throw new FailedPredicateException(this, "usageUsed == 0");
						setState(119);
						dataUsageClause();
						usageUsed++;
						}
						break;
					case 6:
						{
						setState(122);
						if (!(dataValueUsed == 0)) throw new FailedPredicateException(this, "dataValueUsed == 0");
						setState(123);
						dataValueClause();
						dataValueUsed++;
						}
						break;
					case 7:
						{
						setState(126);
						if (!(occursUsed == 0)) throw new FailedPredicateException(this, "occursUsed == 0");
						setState(127);
						dataOccursClause();
						occursUsed++;
						}
						break;
					case 8:
						{
						setState(130);
						if (!(signUsed == 0)) throw new FailedPredicateException(this, "signUsed == 0");
						setState(131);
						dataSignClause();
						signUsed++;
						}
						break;
					case 9:
						{
						setState(134);
						if (!(synchronizedUsed == 0)) throw new FailedPredicateException(this, "synchronizedUsed == 0");
						setState(135);
						dataSynchronizedClause();
						synchronizedUsed++;
						}
						break;
					case 10:
						{
						setState(138);
						if (!(justifiedUsed == 0)) throw new FailedPredicateException(this, "justifiedUsed == 0");
						setState(139);
						dataJustifiedClause();
						justifiedUsed++;
						}
						break;
					case 11:
						{
						setState(142);
						if (!(blankWhenZeroUsed == 0)) throw new FailedPredicateException(this, "blankWhenZeroUsed == 0");
						setState(143);
						dataBlankWhenZeroClause();
						blankWhenZeroUsed++;
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}

			        redefinesUsed = 0;
			        blankWhenZeroUsed = 0;
			        externalUsed = 0;
			        globalUsed = 0;
			        justifiedUsed = 0;
			        occursUsed = 0;
			        pictureUsed = 0;
			        signUsed = 0;
			        synchronizedUsed = 0;
			        usageUsed = 0;
			        dataValueUsed = 0;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionEntryFormat2Context extends ParserRuleContext {
		public TerminalNode LEVEL_NUMBER_66() { return getToken(CopyBookParser.LEVEL_NUMBER_66, 0); }
		public DataNameContext dataName() {
			return getRuleContext(DataNameContext.class,0);
		}
		public DataRenamesClauseContext dataRenamesClause() {
			return getRuleContext(DataRenamesClauseContext.class,0);
		}
		public TerminalNode DOT_FS() { return getToken(CopyBookParser.DOT_FS, 0); }
		public DataDescriptionEntryFormat2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescriptionEntryFormat2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescriptionEntryFormat2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionEntryFormat2Context dataDescriptionEntryFormat2() throws RecognitionException {
		DataDescriptionEntryFormat2Context _localctx = new DataDescriptionEntryFormat2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataDescriptionEntryFormat2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LEVEL_NUMBER_66);
			setState(154);
			dataName();
			setState(155);
			dataRenamesClause();
			setState(156);
			match(DOT_FS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataDescriptionEntryFormat3Context extends ParserRuleContext {
		public TerminalNode LEVEL_NUMBER_88() { return getToken(CopyBookParser.LEVEL_NUMBER_88, 0); }
		public ConditionNameContext conditionName() {
			return getRuleContext(ConditionNameContext.class,0);
		}
		public DataValueClauseContext dataValueClause() {
			return getRuleContext(DataValueClauseContext.class,0);
		}
		public TerminalNode DOT_FS() { return getToken(CopyBookParser.DOT_FS, 0); }
		public DataDescriptionEntryFormat3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDescriptionEntryFormat3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataDescriptionEntryFormat3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDescriptionEntryFormat3Context dataDescriptionEntryFormat3() throws RecognitionException {
		DataDescriptionEntryFormat3Context _localctx = new DataDescriptionEntryFormat3Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_dataDescriptionEntryFormat3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(LEVEL_NUMBER_88);
			setState(159);
			conditionName();
			setState(160);
			dataValueClause();
			setState(161);
			match(DOT_FS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataBlankWhenZeroClauseContext extends ParserRuleContext {
		public TerminalNode BLANK() { return getToken(CopyBookParser.BLANK, 0); }
		public TerminalNode ZERO() { return getToken(CopyBookParser.ZERO, 0); }
		public TerminalNode ZEROS() { return getToken(CopyBookParser.ZEROS, 0); }
		public TerminalNode ZEROES() { return getToken(CopyBookParser.ZEROES, 0); }
		public TerminalNode WHEN() { return getToken(CopyBookParser.WHEN, 0); }
		public DataBlankWhenZeroClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlankWhenZeroClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataBlankWhenZeroClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataBlankWhenZeroClauseContext dataBlankWhenZeroClause() throws RecognitionException {
		DataBlankWhenZeroClauseContext _localctx = new DataBlankWhenZeroClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataBlankWhenZeroClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(BLANK);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(164);
				match(WHEN);
				}
			}

			setState(167);
			_la = _input.LA(1);
			if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataExternalClauseContext extends ParserRuleContext {
		public TerminalNode EXTERNAL() { return getToken(CopyBookParser.EXTERNAL, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public TerminalNode BY() { return getToken(CopyBookParser.BY, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public DataExternalClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataExternalClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataExternalClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataExternalClauseContext dataExternalClause() throws RecognitionException {
		DataExternalClauseContext _localctx = new DataExternalClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataExternalClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(169);
				match(IS);
				}
			}

			setState(172);
			match(EXTERNAL);
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(173);
				match(BY);
				setState(174);
				literal();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataGlobalClauseContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(CopyBookParser.GLOBAL, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public DataGlobalClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataGlobalClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataGlobalClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataGlobalClauseContext dataGlobalClause() throws RecognitionException {
		DataGlobalClauseContext _localctx = new DataGlobalClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dataGlobalClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(177);
				match(IS);
				}
			}

			setState(180);
			match(GLOBAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataJustifiedClauseContext extends ParserRuleContext {
		public TerminalNode JUSTIFIED() { return getToken(CopyBookParser.JUSTIFIED, 0); }
		public TerminalNode JUST() { return getToken(CopyBookParser.JUST, 0); }
		public TerminalNode RIGHT() { return getToken(CopyBookParser.RIGHT, 0); }
		public DataJustifiedClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataJustifiedClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataJustifiedClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataJustifiedClauseContext dataJustifiedClause() throws RecognitionException {
		DataJustifiedClauseContext _localctx = new DataJustifiedClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dataJustifiedClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==JUST || _la==JUSTIFIED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(183);
				match(RIGHT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataOccursClauseContext extends ParserRuleContext {
		public TerminalNode OCCURS() { return getToken(CopyBookParser.OCCURS, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public DataOccursToContext dataOccursTo() {
			return getRuleContext(DataOccursToContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(CopyBookParser.TIMES, 0); }
		public TerminalNode DEPENDING() { return getToken(CopyBookParser.DEPENDING, 0); }
		public QualifiedDataNameContext qualifiedDataName() {
			return getRuleContext(QualifiedDataNameContext.class,0);
		}
		public List<DataOccursSortContext> dataOccursSort() {
			return getRuleContexts(DataOccursSortContext.class);
		}
		public DataOccursSortContext dataOccursSort(int i) {
			return getRuleContext(DataOccursSortContext.class,i);
		}
		public TerminalNode INDEXED() { return getToken(CopyBookParser.INDEXED, 0); }
		public TerminalNode ON() { return getToken(CopyBookParser.ON, 0); }
		public TerminalNode BY() { return getToken(CopyBookParser.BY, 0); }
		public TerminalNode LOCAL() { return getToken(CopyBookParser.LOCAL, 0); }
		public List<IndexNameContext> indexName() {
			return getRuleContexts(IndexNameContext.class);
		}
		public IndexNameContext indexName(int i) {
			return getRuleContext(IndexNameContext.class,i);
		}
		public DataOccursClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataOccursClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataOccursClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataOccursClauseContext dataOccursClause() throws RecognitionException {
		DataOccursClauseContext _localctx = new DataOccursClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dataOccursClause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(OCCURS);
			setState(187);
			integerLiteral();
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(188);
				dataOccursTo();
				}
				break;
			}
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(191);
				match(TIMES);
				}
				break;
			}
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(194);
				match(DEPENDING);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(195);
					match(ON);
					}
				}

				setState(198);
				qualifiedDataName();
				}
				break;
			}
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					dataOccursSort();
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(207);
				match(INDEXED);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BY) {
					{
					setState(208);
					match(BY);
					}
				}

				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(211);
					match(LOCAL);
					}
				}

				setState(215); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(214);
						indexName();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(217); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataOccursToContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(CopyBookParser.TO, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public DataOccursToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataOccursTo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataOccursTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataOccursToContext dataOccursTo() throws RecognitionException {
		DataOccursToContext _localctx = new DataOccursToContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dataOccursTo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(TO);
			setState(222);
			integerLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataOccursSortContext extends ParserRuleContext {
		public TerminalNode ASCENDING() { return getToken(CopyBookParser.ASCENDING, 0); }
		public TerminalNode DESCENDING() { return getToken(CopyBookParser.DESCENDING, 0); }
		public TerminalNode KEY() { return getToken(CopyBookParser.KEY, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public List<QualifiedDataNameContext> qualifiedDataName() {
			return getRuleContexts(QualifiedDataNameContext.class);
		}
		public QualifiedDataNameContext qualifiedDataName(int i) {
			return getRuleContext(QualifiedDataNameContext.class,i);
		}
		public DataOccursSortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataOccursSort; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataOccursSort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataOccursSortContext dataOccursSort() throws RecognitionException {
		DataOccursSortContext _localctx = new DataOccursSortContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dataOccursSort);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !(_la==ASCENDING || _la==DESCENDING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY) {
				{
				setState(225);
				match(KEY);
				}
			}

			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(228);
				match(IS);
				}
			}

			setState(232); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(231);
					qualifiedDataName();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(234); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataPictureClauseContext extends ParserRuleContext {
		public PictureStringContext pictureString() {
			return getRuleContext(PictureStringContext.class,0);
		}
		public TerminalNode PICTURE() { return getToken(CopyBookParser.PICTURE, 0); }
		public TerminalNode PIC() { return getToken(CopyBookParser.PIC, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public DataPictureClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPictureClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataPictureClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataPictureClauseContext dataPictureClause() throws RecognitionException {
		DataPictureClauseContext _localctx = new DataPictureClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dataPictureClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !(_la==PIC || _la==PICTURE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(237);
				match(IS);
				}
			}

			setState(240);
			pictureString();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PictureStringContext extends ParserRuleContext {
		public List<PictureCharsContext> pictureChars() {
			return getRuleContexts(PictureCharsContext.class);
		}
		public PictureCharsContext pictureChars(int i) {
			return getRuleContext(PictureCharsContext.class,i);
		}
		public List<PictureCardinalityContext> pictureCardinality() {
			return getRuleContexts(PictureCardinalityContext.class);
		}
		public PictureCardinalityContext pictureCardinality(int i) {
			return getRuleContext(PictureCardinalityContext.class,i);
		}
		public PictureStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pictureString; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitPictureString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PictureStringContext pictureString() throws RecognitionException {
		PictureStringContext _localctx = new PictureStringContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pictureString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(243); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(242);
							pictureChars();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(245); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(248);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(247);
						pictureCardinality();
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(252); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PictureCharsContext extends ParserRuleContext {
		public TerminalNode DOLLARCHAR() { return getToken(CopyBookParser.DOLLARCHAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CopyBookParser.IDENTIFIER, 0); }
		public TerminalNode NUMERICLITERAL() { return getToken(CopyBookParser.NUMERICLITERAL, 0); }
		public TerminalNode SLASHCHAR() { return getToken(CopyBookParser.SLASHCHAR, 0); }
		public TerminalNode COMMACHAR() { return getToken(CopyBookParser.COMMACHAR, 0); }
		public TerminalNode DOT() { return getToken(CopyBookParser.DOT, 0); }
		public TerminalNode COLONCHAR() { return getToken(CopyBookParser.COLONCHAR, 0); }
		public TerminalNode ASTERISKCHAR() { return getToken(CopyBookParser.ASTERISKCHAR, 0); }
		public TerminalNode DOUBLEASTERISKCHAR() { return getToken(CopyBookParser.DOUBLEASTERISKCHAR, 0); }
		public TerminalNode PLUSCHAR() { return getToken(CopyBookParser.PLUSCHAR, 0); }
		public TerminalNode MINUSCHAR() { return getToken(CopyBookParser.MINUSCHAR, 0); }
		public TerminalNode LESSTHANCHAR() { return getToken(CopyBookParser.LESSTHANCHAR, 0); }
		public TerminalNode MORETHANCHAR() { return getToken(CopyBookParser.MORETHANCHAR, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public PictureCharsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pictureChars; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitPictureChars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PictureCharsContext pictureChars() throws RecognitionException {
		PictureCharsContext _localctx = new PictureCharsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pictureChars);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLARCHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(DOLLARCHAR);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(IDENTIFIER);
				}
				break;
			case NUMERICLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(NUMERICLITERAL);
				}
				break;
			case SLASHCHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(SLASHCHAR);
				}
				break;
			case COMMACHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(COMMACHAR);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				match(DOT);
				}
				break;
			case COLONCHAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				match(COLONCHAR);
				}
				break;
			case ASTERISKCHAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				match(ASTERISKCHAR);
				}
				break;
			case DOUBLEASTERISKCHAR:
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				match(DOUBLEASTERISKCHAR);
				}
				break;
			case PLUSCHAR:
				enterOuterAlt(_localctx, 10);
				{
				setState(263);
				match(PLUSCHAR);
				}
				break;
			case MINUSCHAR:
				enterOuterAlt(_localctx, 11);
				{
				setState(264);
				match(MINUSCHAR);
				}
				break;
			case LESSTHANCHAR:
				enterOuterAlt(_localctx, 12);
				{
				setState(265);
				match(LESSTHANCHAR);
				}
				break;
			case MORETHANCHAR:
				enterOuterAlt(_localctx, 13);
				{
				setState(266);
				match(MORETHANCHAR);
				}
				break;
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
				enterOuterAlt(_localctx, 14);
				{
				setState(267);
				integerLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PictureCardinalityContext extends ParserRuleContext {
		public TerminalNode LPARENCHAR() { return getToken(CopyBookParser.LPARENCHAR, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public TerminalNode RPARENCHAR() { return getToken(CopyBookParser.RPARENCHAR, 0); }
		public PictureCardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pictureCardinality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitPictureCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PictureCardinalityContext pictureCardinality() throws RecognitionException {
		PictureCardinalityContext _localctx = new PictureCardinalityContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pictureCardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(LPARENCHAR);
			setState(271);
			integerLiteral();
			setState(272);
			match(RPARENCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataRedefinesClauseContext extends ParserRuleContext {
		public TerminalNode REDEFINES() { return getToken(CopyBookParser.REDEFINES, 0); }
		public DataNameContext dataName() {
			return getRuleContext(DataNameContext.class,0);
		}
		public DataRedefinesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataRedefinesClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataRedefinesClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataRedefinesClauseContext dataRedefinesClause() throws RecognitionException {
		DataRedefinesClauseContext _localctx = new DataRedefinesClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dataRedefinesClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(REDEFINES);
			setState(275);
			dataName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataRenamesClauseContext extends ParserRuleContext {
		public TerminalNode RENAMES() { return getToken(CopyBookParser.RENAMES, 0); }
		public List<QualifiedDataNameContext> qualifiedDataName() {
			return getRuleContexts(QualifiedDataNameContext.class);
		}
		public QualifiedDataNameContext qualifiedDataName(int i) {
			return getRuleContext(QualifiedDataNameContext.class,i);
		}
		public TerminalNode THROUGH() { return getToken(CopyBookParser.THROUGH, 0); }
		public TerminalNode THRU() { return getToken(CopyBookParser.THRU, 0); }
		public DataRenamesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataRenamesClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataRenamesClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataRenamesClauseContext dataRenamesClause() throws RecognitionException {
		DataRenamesClauseContext _localctx = new DataRenamesClauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dataRenamesClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(RENAMES);
			setState(278);
			qualifiedDataName();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROUGH || _la==THRU) {
				{
				setState(279);
				_la = _input.LA(1);
				if ( !(_la==THROUGH || _la==THRU) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(280);
				qualifiedDataName();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSignClauseContext extends ParserRuleContext {
		public TerminalNode LEADING() { return getToken(CopyBookParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(CopyBookParser.TRAILING, 0); }
		public TerminalNode SIGN() { return getToken(CopyBookParser.SIGN, 0); }
		public TerminalNode SEPARATE() { return getToken(CopyBookParser.SEPARATE, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public TerminalNode CHARACTER() { return getToken(CopyBookParser.CHARACTER, 0); }
		public DataSignClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSignClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataSignClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSignClauseContext dataSignClause() throws RecognitionException {
		DataSignClauseContext _localctx = new DataSignClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_dataSignClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(283);
				match(SIGN);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IS) {
					{
					setState(284);
					match(IS);
					}
				}

				}
			}

			setState(289);
			_la = _input.LA(1);
			if ( !(_la==LEADING || _la==TRAILING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(290);
				match(SEPARATE);
				setState(292);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(291);
					match(CHARACTER);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSynchronizedClauseContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED() { return getToken(CopyBookParser.SYNCHRONIZED, 0); }
		public TerminalNode SYNC() { return getToken(CopyBookParser.SYNC, 0); }
		public TerminalNode LEFT() { return getToken(CopyBookParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(CopyBookParser.RIGHT, 0); }
		public DataSynchronizedClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSynchronizedClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataSynchronizedClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSynchronizedClauseContext dataSynchronizedClause() throws RecognitionException {
		DataSynchronizedClauseContext _localctx = new DataSynchronizedClauseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_dataSynchronizedClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_la = _input.LA(1);
			if ( !(_la==SYNC || _la==SYNCHRONIZED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(297);
				_la = _input.LA(1);
				if ( !(_la==LEFT || _la==RIGHT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataUsageClauseContext extends ParserRuleContext {
		public TerminalNode BINARY() { return getToken(CopyBookParser.BINARY, 0); }
		public TerminalNode BIT() { return getToken(CopyBookParser.BIT, 0); }
		public TerminalNode COMP() { return getToken(CopyBookParser.COMP, 0); }
		public TerminalNode COMP_1() { return getToken(CopyBookParser.COMP_1, 0); }
		public TerminalNode COMP_2() { return getToken(CopyBookParser.COMP_2, 0); }
		public TerminalNode COMP_3() { return getToken(CopyBookParser.COMP_3, 0); }
		public TerminalNode COMP_4() { return getToken(CopyBookParser.COMP_4, 0); }
		public TerminalNode COMP_5() { return getToken(CopyBookParser.COMP_5, 0); }
		public TerminalNode COMPUTATIONAL() { return getToken(CopyBookParser.COMPUTATIONAL, 0); }
		public TerminalNode COMPUTATIONAL_1() { return getToken(CopyBookParser.COMPUTATIONAL_1, 0); }
		public TerminalNode COMPUTATIONAL_2() { return getToken(CopyBookParser.COMPUTATIONAL_2, 0); }
		public TerminalNode COMPUTATIONAL_3() { return getToken(CopyBookParser.COMPUTATIONAL_3, 0); }
		public TerminalNode COMPUTATIONAL_4() { return getToken(CopyBookParser.COMPUTATIONAL_4, 0); }
		public TerminalNode COMPUTATIONAL_5() { return getToken(CopyBookParser.COMPUTATIONAL_5, 0); }
		public TerminalNode CONTROL_POINT() { return getToken(CopyBookParser.CONTROL_POINT, 0); }
		public TerminalNode DATE() { return getToken(CopyBookParser.DATE, 0); }
		public TerminalNode DISPLAY() { return getToken(CopyBookParser.DISPLAY, 0); }
		public TerminalNode DISPLAY_1() { return getToken(CopyBookParser.DISPLAY_1, 0); }
		public TerminalNode DOUBLE() { return getToken(CopyBookParser.DOUBLE, 0); }
		public TerminalNode EVENT() { return getToken(CopyBookParser.EVENT, 0); }
		public TerminalNode FUNCTION_POINTER() { return getToken(CopyBookParser.FUNCTION_POINTER, 0); }
		public TerminalNode INDEX() { return getToken(CopyBookParser.INDEX, 0); }
		public TerminalNode KANJI() { return getToken(CopyBookParser.KANJI, 0); }
		public TerminalNode LOCK() { return getToken(CopyBookParser.LOCK, 0); }
		public TerminalNode NATIONAL() { return getToken(CopyBookParser.NATIONAL, 0); }
		public TerminalNode PACKED_DECIMAL() { return getToken(CopyBookParser.PACKED_DECIMAL, 0); }
		public TerminalNode POINTER() { return getToken(CopyBookParser.POINTER, 0); }
		public TerminalNode PROCEDURE_POINTER() { return getToken(CopyBookParser.PROCEDURE_POINTER, 0); }
		public TerminalNode REAL() { return getToken(CopyBookParser.REAL, 0); }
		public TerminalNode TASK() { return getToken(CopyBookParser.TASK, 0); }
		public TerminalNode USAGE() { return getToken(CopyBookParser.USAGE, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public TerminalNode TRUNCATED() { return getToken(CopyBookParser.TRUNCATED, 0); }
		public TerminalNode EXTENDED() { return getToken(CopyBookParser.EXTENDED, 0); }
		public DataUsageClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataUsageClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataUsageClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataUsageClauseContext dataUsageClause() throws RecognitionException {
		DataUsageClauseContext _localctx = new DataUsageClauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dataUsageClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USAGE) {
				{
				setState(300);
				match(USAGE);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IS) {
					{
					setState(301);
					match(IS);
					}
				}

				}
			}

			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY:
				{
				setState(306);
				match(BINARY);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(307);
					_la = _input.LA(1);
					if ( !(_la==EXTENDED || _la==TRUNCATED) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case BIT:
				{
				setState(310);
				match(BIT);
				}
				break;
			case COMP:
				{
				setState(311);
				match(COMP);
				}
				break;
			case COMP_1:
				{
				setState(312);
				match(COMP_1);
				}
				break;
			case COMP_2:
				{
				setState(313);
				match(COMP_2);
				}
				break;
			case COMP_3:
				{
				setState(314);
				match(COMP_3);
				}
				break;
			case COMP_4:
				{
				setState(315);
				match(COMP_4);
				}
				break;
			case COMP_5:
				{
				setState(316);
				match(COMP_5);
				}
				break;
			case COMPUTATIONAL:
				{
				setState(317);
				match(COMPUTATIONAL);
				}
				break;
			case COMPUTATIONAL_1:
				{
				setState(318);
				match(COMPUTATIONAL_1);
				}
				break;
			case COMPUTATIONAL_2:
				{
				setState(319);
				match(COMPUTATIONAL_2);
				}
				break;
			case COMPUTATIONAL_3:
				{
				setState(320);
				match(COMPUTATIONAL_3);
				}
				break;
			case COMPUTATIONAL_4:
				{
				setState(321);
				match(COMPUTATIONAL_4);
				}
				break;
			case COMPUTATIONAL_5:
				{
				setState(322);
				match(COMPUTATIONAL_5);
				}
				break;
			case CONTROL_POINT:
				{
				setState(323);
				match(CONTROL_POINT);
				}
				break;
			case DATE:
				{
				setState(324);
				match(DATE);
				}
				break;
			case DISPLAY:
				{
				setState(325);
				match(DISPLAY);
				}
				break;
			case DISPLAY_1:
				{
				setState(326);
				match(DISPLAY_1);
				}
				break;
			case DOUBLE:
				{
				setState(327);
				match(DOUBLE);
				}
				break;
			case EVENT:
				{
				setState(328);
				match(EVENT);
				}
				break;
			case FUNCTION_POINTER:
				{
				setState(329);
				match(FUNCTION_POINTER);
				}
				break;
			case INDEX:
				{
				setState(330);
				match(INDEX);
				}
				break;
			case KANJI:
				{
				setState(331);
				match(KANJI);
				}
				break;
			case LOCK:
				{
				setState(332);
				match(LOCK);
				}
				break;
			case NATIONAL:
				{
				setState(333);
				match(NATIONAL);
				}
				break;
			case PACKED_DECIMAL:
				{
				setState(334);
				match(PACKED_DECIMAL);
				}
				break;
			case POINTER:
				{
				setState(335);
				match(POINTER);
				}
				break;
			case PROCEDURE_POINTER:
				{
				setState(336);
				match(PROCEDURE_POINTER);
				}
				break;
			case REAL:
				{
				setState(337);
				match(REAL);
				}
				break;
			case TASK:
				{
				setState(338);
				match(TASK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataValueClauseContext extends ParserRuleContext {
		public List<DataValueIntervalContext> dataValueInterval() {
			return getRuleContexts(DataValueIntervalContext.class);
		}
		public DataValueIntervalContext dataValueInterval(int i) {
			return getRuleContext(DataValueIntervalContext.class,i);
		}
		public TerminalNode VALUE() { return getToken(CopyBookParser.VALUE, 0); }
		public TerminalNode VALUES() { return getToken(CopyBookParser.VALUES, 0); }
		public TerminalNode IS() { return getToken(CopyBookParser.IS, 0); }
		public TerminalNode ARE() { return getToken(CopyBookParser.ARE, 0); }
		public List<TerminalNode> COMMACHAR() { return getTokens(CopyBookParser.COMMACHAR); }
		public TerminalNode COMMACHAR(int i) {
			return getToken(CopyBookParser.COMMACHAR, i);
		}
		public DataValueClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValueClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataValueClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueClauseContext dataValueClause() throws RecognitionException {
		DataValueClauseContext _localctx = new DataValueClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dataValueClause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				{
				setState(341);
				match(VALUE);
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IS) {
					{
					setState(342);
					match(IS);
					}
				}

				}
				break;
			case VALUES:
				{
				setState(345);
				match(VALUES);
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARE) {
					{
					setState(346);
					match(ARE);
					}
				}

				}
				break;
			case ALL:
			case DFHRESP:
			case DFHVALUE:
			case FALSE:
			case HIGH_VALUE:
			case HIGH_VALUES:
			case LOW_VALUE:
			case LOW_VALUES:
			case NULL_:
			case NULLS:
			case QUOTE:
			case QUOTES:
			case SPACE:
			case SPACES:
			case TRUE:
			case ZERO:
			case ZEROS:
			case ZEROES:
			case NONNUMERICLITERAL:
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
			case NUMERICLITERAL:
			case IDENTIFIER:
				break;
			default:
				break;
			}
			setState(351);
			dataValueInterval();
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMACHAR) {
						{
						setState(352);
						match(COMMACHAR);
						}
					}

					setState(355);
					dataValueInterval();
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataValueIntervalContext extends ParserRuleContext {
		public DataValueIntervalFromContext dataValueIntervalFrom() {
			return getRuleContext(DataValueIntervalFromContext.class,0);
		}
		public DataValueIntervalToContext dataValueIntervalTo() {
			return getRuleContext(DataValueIntervalToContext.class,0);
		}
		public DataValueIntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValueInterval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataValueInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueIntervalContext dataValueInterval() throws RecognitionException {
		DataValueIntervalContext _localctx = new DataValueIntervalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dataValueInterval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			dataValueIntervalFrom();
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(362);
				dataValueIntervalTo();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataValueIntervalFromContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public DataValueIntervalFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValueIntervalFrom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataValueIntervalFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueIntervalFromContext dataValueIntervalFrom() throws RecognitionException {
		DataValueIntervalFromContext _localctx = new DataValueIntervalFromContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dataValueIntervalFrom);
		try {
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALL:
			case DFHRESP:
			case DFHVALUE:
			case FALSE:
			case HIGH_VALUE:
			case HIGH_VALUES:
			case LOW_VALUE:
			case LOW_VALUES:
			case NULL_:
			case NULLS:
			case QUOTE:
			case QUOTES:
			case SPACE:
			case SPACES:
			case TRUE:
			case ZERO:
			case ZEROS:
			case ZEROES:
			case NONNUMERICLITERAL:
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
			case NUMERICLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				literal();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				cobolWord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataValueIntervalToContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode THROUGH() { return getToken(CopyBookParser.THROUGH, 0); }
		public TerminalNode THRU() { return getToken(CopyBookParser.THRU, 0); }
		public DataValueIntervalToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValueIntervalTo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataValueIntervalTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueIntervalToContext dataValueIntervalTo() throws RecognitionException {
		DataValueIntervalToContext _localctx = new DataValueIntervalToContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dataValueIntervalTo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( !(_la==THROUGH || _la==THRU) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(370);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public QualifiedDataNameContext qualifiedDataName() {
			return getRuleContext(QualifiedDataNameContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			qualifiedDataName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedDataNameContext extends ParserRuleContext {
		public DataNameContext dataName() {
			return getRuleContext(DataNameContext.class,0);
		}
		public ConditionNameContext conditionName() {
			return getRuleContext(ConditionNameContext.class,0);
		}
		public QualifiedDataNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedDataName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitQualifiedDataName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedDataNameContext qualifiedDataName() throws RecognitionException {
		QualifiedDataNameContext _localctx = new QualifiedDataNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_qualifiedDataName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(374);
				dataName();
				}
				break;
			case 2:
				{
				setState(375);
				conditionName();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionNameContext extends ParserRuleContext {
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public ConditionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitConditionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionNameContext conditionName() throws RecognitionException {
		ConditionNameContext _localctx = new ConditionNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_conditionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			cobolWord();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataNameContext extends ParserRuleContext {
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public DataNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitDataName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataNameContext dataName() throws RecognitionException {
		DataNameContext _localctx = new DataNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dataName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			cobolWord();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexNameContext extends ParserRuleContext {
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public IndexNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitIndexName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexNameContext indexName() throws RecognitionException {
		IndexNameContext _localctx = new IndexNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_indexName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			cobolWord();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CobolWordContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CopyBookParser.IDENTIFIER, 0); }
		public CobolWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cobolWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitCobolWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CobolWordContext cobolWord() throws RecognitionException {
		CobolWordContext _localctx = new CobolWordContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_cobolWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NONNUMERICLITERAL() { return getToken(CopyBookParser.NONNUMERICLITERAL, 0); }
		public FigurativeConstantContext figurativeConstant() {
			return getRuleContext(FigurativeConstantContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public CicsDfhRespLiteralContext cicsDfhRespLiteral() {
			return getRuleContext(CicsDfhRespLiteralContext.class,0);
		}
		public CicsDfhValueLiteralContext cicsDfhValueLiteral() {
			return getRuleContext(CicsDfhValueLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		try {
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				match(NONNUMERICLITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				figurativeConstant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				numericLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(389);
				booleanLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(390);
				cicsDfhRespLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(391);
				cicsDfhValueLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(CopyBookParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CopyBookParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericLiteralContext extends ParserRuleContext {
		public TerminalNode NUMERICLITERAL() { return getToken(CopyBookParser.NUMERICLITERAL, 0); }
		public TerminalNode ZERO() { return getToken(CopyBookParser.ZERO, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_numericLiteral);
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(NUMERICLITERAL);
				}
				break;
			case ZERO:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(ZERO);
				}
				break;
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				integerLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode INTEGERLITERAL() { return getToken(CopyBookParser.INTEGERLITERAL, 0); }
		public TerminalNode LEVEL_NUMBER_66() { return getToken(CopyBookParser.LEVEL_NUMBER_66, 0); }
		public TerminalNode LEVEL_NUMBER_77() { return getToken(CopyBookParser.LEVEL_NUMBER_77, 0); }
		public TerminalNode LEVEL_NUMBER_88() { return getToken(CopyBookParser.LEVEL_NUMBER_88, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_la = _input.LA(1);
			if ( !(((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicsDfhRespLiteralContext extends ParserRuleContext {
		public TerminalNode DFHRESP() { return getToken(CopyBookParser.DFHRESP, 0); }
		public TerminalNode LPARENCHAR() { return getToken(CopyBookParser.LPARENCHAR, 0); }
		public TerminalNode RPARENCHAR() { return getToken(CopyBookParser.RPARENCHAR, 0); }
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CicsDfhRespLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicsDfhRespLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitCicsDfhRespLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicsDfhRespLiteralContext cicsDfhRespLiteral() throws RecognitionException {
		CicsDfhRespLiteralContext _localctx = new CicsDfhRespLiteralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cicsDfhRespLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(DFHRESP);
			setState(404);
			match(LPARENCHAR);
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(405);
				cobolWord();
				}
				break;
			case ALL:
			case DFHRESP:
			case DFHVALUE:
			case FALSE:
			case HIGH_VALUE:
			case HIGH_VALUES:
			case LOW_VALUE:
			case LOW_VALUES:
			case NULL_:
			case NULLS:
			case QUOTE:
			case QUOTES:
			case SPACE:
			case SPACES:
			case TRUE:
			case ZERO:
			case ZEROS:
			case ZEROES:
			case NONNUMERICLITERAL:
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
			case NUMERICLITERAL:
				{
				setState(406);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(409);
			match(RPARENCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicsDfhValueLiteralContext extends ParserRuleContext {
		public TerminalNode DFHVALUE() { return getToken(CopyBookParser.DFHVALUE, 0); }
		public TerminalNode LPARENCHAR() { return getToken(CopyBookParser.LPARENCHAR, 0); }
		public TerminalNode RPARENCHAR() { return getToken(CopyBookParser.RPARENCHAR, 0); }
		public CobolWordContext cobolWord() {
			return getRuleContext(CobolWordContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CicsDfhValueLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicsDfhValueLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitCicsDfhValueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicsDfhValueLiteralContext cicsDfhValueLiteral() throws RecognitionException {
		CicsDfhValueLiteralContext _localctx = new CicsDfhValueLiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_cicsDfhValueLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(DFHVALUE);
			setState(412);
			match(LPARENCHAR);
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(413);
				cobolWord();
				}
				break;
			case ALL:
			case DFHRESP:
			case DFHVALUE:
			case FALSE:
			case HIGH_VALUE:
			case HIGH_VALUES:
			case LOW_VALUE:
			case LOW_VALUES:
			case NULL_:
			case NULLS:
			case QUOTE:
			case QUOTES:
			case SPACE:
			case SPACES:
			case TRUE:
			case ZERO:
			case ZEROS:
			case ZEROES:
			case NONNUMERICLITERAL:
			case LEVEL_NUMBER_66:
			case LEVEL_NUMBER_77:
			case LEVEL_NUMBER_88:
			case INTEGERLITERAL:
			case NUMERICLITERAL:
				{
				setState(414);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(417);
			match(RPARENCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FigurativeConstantContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(CopyBookParser.ALL, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode HIGH_VALUE() { return getToken(CopyBookParser.HIGH_VALUE, 0); }
		public TerminalNode HIGH_VALUES() { return getToken(CopyBookParser.HIGH_VALUES, 0); }
		public TerminalNode LOW_VALUE() { return getToken(CopyBookParser.LOW_VALUE, 0); }
		public TerminalNode LOW_VALUES() { return getToken(CopyBookParser.LOW_VALUES, 0); }
		public TerminalNode NULL_() { return getToken(CopyBookParser.NULL_, 0); }
		public TerminalNode NULLS() { return getToken(CopyBookParser.NULLS, 0); }
		public TerminalNode QUOTE() { return getToken(CopyBookParser.QUOTE, 0); }
		public TerminalNode QUOTES() { return getToken(CopyBookParser.QUOTES, 0); }
		public TerminalNode SPACE() { return getToken(CopyBookParser.SPACE, 0); }
		public TerminalNode SPACES() { return getToken(CopyBookParser.SPACES, 0); }
		public TerminalNode ZERO() { return getToken(CopyBookParser.ZERO, 0); }
		public TerminalNode ZEROS() { return getToken(CopyBookParser.ZEROS, 0); }
		public TerminalNode ZEROES() { return getToken(CopyBookParser.ZEROES, 0); }
		public FigurativeConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figurativeConstant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CopyBookVisitor ) return ((CopyBookVisitor<? extends T>)visitor).visitFigurativeConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigurativeConstantContext figurativeConstant() throws RecognitionException {
		FigurativeConstantContext _localctx = new FigurativeConstantContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_figurativeConstant);
		try {
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(ALL);
				setState(420);
				literal();
				}
				break;
			case HIGH_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				match(HIGH_VALUE);
				}
				break;
			case HIGH_VALUES:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				match(HIGH_VALUES);
				}
				break;
			case LOW_VALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				match(LOW_VALUE);
				}
				break;
			case LOW_VALUES:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				match(LOW_VALUES);
				}
				break;
			case NULL_:
				enterOuterAlt(_localctx, 6);
				{
				setState(425);
				match(NULL_);
				}
				break;
			case NULLS:
				enterOuterAlt(_localctx, 7);
				{
				setState(426);
				match(NULLS);
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 8);
				{
				setState(427);
				match(QUOTE);
				}
				break;
			case QUOTES:
				enterOuterAlt(_localctx, 9);
				{
				setState(428);
				match(QUOTES);
				}
				break;
			case SPACE:
				enterOuterAlt(_localctx, 10);
				{
				setState(429);
				match(SPACE);
				}
				break;
			case SPACES:
				enterOuterAlt(_localctx, 11);
				{
				setState(430);
				match(SPACES);
				}
				break;
			case ZERO:
				enterOuterAlt(_localctx, 12);
				{
				setState(431);
				match(ZERO);
				}
				break;
			case ZEROS:
				enterOuterAlt(_localctx, 13);
				{
				setState(432);
				match(ZEROS);
				}
				break;
			case ZEROES:
				enterOuterAlt(_localctx, 14);
				{
				setState(433);
				match(ZEROES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return dataDescriptionEntryClauses_sempred((DataDescriptionEntryClausesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dataDescriptionEntryClauses_sempred(DataDescriptionEntryClausesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return redefinesUsed == 0;
		case 1:
			return externalUsed == 0;
		case 2:
			return globalUsed == 0;
		case 3:
			return pictureUsed == 0;
		case 4:
			return usageUsed == 0;
		case 5:
			return dataValueUsed == 0;
		case 6:
			return occursUsed == 0;
		case 7:
			return signUsed == 0;
		case 8:
			return synchronizedUsed == 0;
		case 9:
			return justifiedUsed == 0;
		case 10:
			return blankWhenZeroUsed == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001{\u01b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001U\b\u0001\u000b"+
		"\u0001\f\u0001V\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002]\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003b\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u0093\b\u0004\n\u0004\f\u0004\u0096\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00a6\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0003\b\u00ab\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u00b0\b\b\u0001\t\u0003\t\u00b3\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0003\n\u00b9\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00be\b\u000b\u0001\u000b\u0003\u000b\u00c1\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00c5\b\u000b\u0001\u000b\u0003\u000b"+
		"\u00c8\b\u000b\u0001\u000b\u0005\u000b\u00cb\b\u000b\n\u000b\f\u000b\u00ce"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d2\b\u000b\u0001\u000b"+
		"\u0003\u000b\u00d5\b\u000b\u0001\u000b\u0004\u000b\u00d8\b\u000b\u000b"+
		"\u000b\f\u000b\u00d9\u0003\u000b\u00dc\b\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0003\r\u00e3\b\r\u0001\r\u0003\r\u00e6\b\r\u0001\r\u0004"+
		"\r\u00e9\b\r\u000b\r\f\r\u00ea\u0001\u000e\u0001\u000e\u0003\u000e\u00ef"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f\u00f4\b\u000f"+
		"\u000b\u000f\f\u000f\u00f5\u0001\u000f\u0003\u000f\u00f9\b\u000f\u0004"+
		"\u000f\u00fb\b\u000f\u000b\u000f\f\u000f\u00fc\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u010d\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u011a\b\u0013\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u011e\b\u0014\u0003\u0014\u0120\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0125\b\u0014\u0003\u0014\u0127\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u012b\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u012f\b\u0016\u0003\u0016\u0131\b\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0135\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0154\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0158"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u015c\b\u0017\u0003\u0017"+
		"\u015e\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0162\b\u0017\u0001"+
		"\u0017\u0005\u0017\u0165\b\u0017\n\u0017\f\u0017\u0168\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u016c\b\u0018\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u0170\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0179\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!"+
		"\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u0189\b!\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0003#\u0190\b#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u0198\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003&\u01a0"+
		"\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u01b3\b\'\u0001\'\u0000\u0000(\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLN\u0000\f\u0002\u0000ttvv\u0001\u0000ac\u0001\u0000/0\u0002\u0000\u0003"+
		"\u0003\u001b\u001b\u0001\u0000AB\u0001\u0000TU\u0002\u000033XX\u0001\u0000"+
		"QR\u0002\u000044JJ\u0002\u0000\"\"ZZ\u0002\u0000$$YY\u0001\u0000sv\u0204"+
		"\u0000P\u0001\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004\\"+
		"\u0001\u0000\u0000\u0000\u0006^\u0001\u0000\u0000\u0000\b\u0094\u0001"+
		"\u0000\u0000\u0000\n\u0099\u0001\u0000\u0000\u0000\f\u009e\u0001\u0000"+
		"\u0000\u0000\u000e\u00a3\u0001\u0000\u0000\u0000\u0010\u00aa\u0001\u0000"+
		"\u0000\u0000\u0012\u00b2\u0001\u0000\u0000\u0000\u0014\u00b6\u0001\u0000"+
		"\u0000\u0000\u0016\u00ba\u0001\u0000\u0000\u0000\u0018\u00dd\u0001\u0000"+
		"\u0000\u0000\u001a\u00e0\u0001\u0000\u0000\u0000\u001c\u00ec\u0001\u0000"+
		"\u0000\u0000\u001e\u00fa\u0001\u0000\u0000\u0000 \u010c\u0001\u0000\u0000"+
		"\u0000\"\u010e\u0001\u0000\u0000\u0000$\u0112\u0001\u0000\u0000\u0000"+
		"&\u0115\u0001\u0000\u0000\u0000(\u011f\u0001\u0000\u0000\u0000*\u0128"+
		"\u0001\u0000\u0000\u0000,\u0130\u0001\u0000\u0000\u0000.\u015d\u0001\u0000"+
		"\u0000\u00000\u0169\u0001\u0000\u0000\u00002\u016f\u0001\u0000\u0000\u0000"+
		"4\u0171\u0001\u0000\u0000\u00006\u0174\u0001\u0000\u0000\u00008\u0178"+
		"\u0001\u0000\u0000\u0000:\u017a\u0001\u0000\u0000\u0000<\u017c\u0001\u0000"+
		"\u0000\u0000>\u017e\u0001\u0000\u0000\u0000@\u0180\u0001\u0000\u0000\u0000"+
		"B\u0188\u0001\u0000\u0000\u0000D\u018a\u0001\u0000\u0000\u0000F\u018f"+
		"\u0001\u0000\u0000\u0000H\u0191\u0001\u0000\u0000\u0000J\u0193\u0001\u0000"+
		"\u0000\u0000L\u019b\u0001\u0000\u0000\u0000N\u01b2\u0001\u0000\u0000\u0000"+
		"PQ\u0003\u0002\u0001\u0000QR\u0005\u0000\u0000\u0001R\u0001\u0001\u0000"+
		"\u0000\u0000SU\u0003\u0004\u0002\u0000TS\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"W\u0003\u0001\u0000\u0000\u0000X]\u0003\u0006\u0003\u0000Y]\u0003\n\u0005"+
		"\u0000Z]\u0003\f\u0006\u0000[]\u0005{\u0000\u0000\\X\u0001\u0000\u0000"+
		"\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001"+
		"\u0000\u0000\u0000]\u0005\u0001\u0000\u0000\u0000^a\u0007\u0000\u0000"+
		"\u0000_b\u0005%\u0000\u0000`b\u0003<\u001e\u0000a_\u0001\u0000\u0000\u0000"+
		"a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0003\b\u0004\u0000de\u0005i\u0000\u0000e\u0007\u0001\u0000\u0000"+
		"\u0000fg\u0004\u0004\u0000\u0000gh\u0003$\u0012\u0000hi\u0006\u0004\uffff"+
		"\uffff\u0000i\u0093\u0001\u0000\u0000\u0000jk\u0004\u0004\u0001\u0000"+
		"kl\u0003\u0010\b\u0000lm\u0006\u0004\uffff\uffff\u0000m\u0093\u0001\u0000"+
		"\u0000\u0000no\u0004\u0004\u0002\u0000op\u0003\u0012\t\u0000pq\u0006\u0004"+
		"\uffff\uffff\u0000q\u0093\u0001\u0000\u0000\u0000rs\u0004\u0004\u0003"+
		"\u0000st\u0003\u001c\u000e\u0000tu\u0006\u0004\uffff\uffff\u0000u\u0093"+
		"\u0001\u0000\u0000\u0000vw\u0004\u0004\u0004\u0000wx\u0003,\u0016\u0000"+
		"xy\u0006\u0004\uffff\uffff\u0000y\u0093\u0001\u0000\u0000\u0000z{\u0004"+
		"\u0004\u0005\u0000{|\u0003.\u0017\u0000|}\u0006\u0004\uffff\uffff\u0000"+
		"}\u0093\u0001\u0000\u0000\u0000~\u007f\u0004\u0004\u0006\u0000\u007f\u0080"+
		"\u0003\u0016\u000b\u0000\u0080\u0081\u0006\u0004\uffff\uffff\u0000\u0081"+
		"\u0093\u0001\u0000\u0000\u0000\u0082\u0083\u0004\u0004\u0007\u0000\u0083"+
		"\u0084\u0003(\u0014\u0000\u0084\u0085\u0006\u0004\uffff\uffff\u0000\u0085"+
		"\u0093\u0001\u0000\u0000\u0000\u0086\u0087\u0004\u0004\b\u0000\u0087\u0088"+
		"\u0003*\u0015\u0000\u0088\u0089\u0006\u0004\uffff\uffff\u0000\u0089\u0093"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0004\u0004\t\u0000\u008b\u008c\u0003"+
		"\u0014\n\u0000\u008c\u008d\u0006\u0004\uffff\uffff\u0000\u008d\u0093\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0004\u0004\n\u0000\u008f\u0090\u0003\u000e"+
		"\u0007\u0000\u0090\u0091\u0006\u0004\uffff\uffff\u0000\u0091\u0093\u0001"+
		"\u0000\u0000\u0000\u0092f\u0001\u0000\u0000\u0000\u0092j\u0001\u0000\u0000"+
		"\u0000\u0092n\u0001\u0000\u0000\u0000\u0092r\u0001\u0000\u0000\u0000\u0092"+
		"v\u0001\u0000\u0000\u0000\u0092z\u0001\u0000\u0000\u0000\u0092~\u0001"+
		"\u0000\u0000\u0000\u0092\u0082\u0001\u0000\u0000\u0000\u0092\u0086\u0001"+
		"\u0000\u0000\u0000\u0092\u008a\u0001\u0000\u0000\u0000\u0092\u008e\u0001"+
		"\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0097\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0006"+
		"\u0004\uffff\uffff\u0000\u0098\t\u0001\u0000\u0000\u0000\u0099\u009a\u0005"+
		"s\u0000\u0000\u009a\u009b\u0003<\u001e\u0000\u009b\u009c\u0003&\u0013"+
		"\u0000\u009c\u009d\u0005i\u0000\u0000\u009d\u000b\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0005u\u0000\u0000\u009f\u00a0\u0003:\u001d\u0000\u00a0\u00a1"+
		"\u0003.\u0017\u0000\u00a1\u00a2\u0005i\u0000\u0000\u00a2\r\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a5\u0005\u0006\u0000\u0000\u00a4\u00a6\u0005_\u0000"+
		"\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0007\u0001\u0000"+
		"\u0000\u00a8\u000f\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005.\u0000\u0000"+
		"\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00af\u0005#\u0000\u0000\u00ad"+
		"\u00ae\u0005\u0007\u0000\u0000\u00ae\u00b0\u0003B!\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u0011\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0005.\u0000\u0000\u00b2\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0005(\u0000\u0000\u00b5\u0013\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b8\u0007\u0002\u0000\u0000\u00b7\u00b9\u0005J\u0000\u0000"+
		"\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005=\u0000\u0000\u00bb"+
		"\u00bd\u0003H$\u0000\u00bc\u00be\u0003\u0018\f\u0000\u00bd\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c1\u0005V\u0000\u0000\u00c0\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0005\u001a\u0000\u0000\u00c3\u00c5\u0005?\u0000"+
		"\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u00038\u001c\u0000"+
		"\u00c7\u00c2\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c8\u00cc\u0001\u0000\u0000\u0000\u00c9\u00cb\u0003\u001a\r\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00db\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d1\u0005,\u0000\u0000\u00d0\u00d2\u0005\u0007\u0000\u0000\u00d1\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d5\u00056\u0000\u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0003>\u001f\u0000\u00d7\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dc\u0001\u0000"+
		"\u0000\u0000\u00db\u00cf\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc\u0017\u0001\u0000\u0000\u0000\u00dd\u00de\u0005W\u0000"+
		"\u0000\u00de\u00df\u0003H$\u0000\u00df\u0019\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e2\u0007\u0003\u0000\u0000\u00e1\u00e3\u00052\u0000\u0000\u00e2\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e6\u0005.\u0000\u0000\u00e5\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e9\u00038\u001c\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u001b\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ee\u0007\u0004\u0000\u0000\u00ed\u00ef\u0005.\u0000"+
		"\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003\u001e\u000f"+
		"\u0000\u00f1\u001d\u0001\u0000\u0000\u0000\u00f2\u00f4\u0003 \u0010\u0000"+
		"\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f9\u0003\"\u0011\u0000\u00f8"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fa\u00f3\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fd\u001f\u0001\u0000\u0000\u0000\u00fe"+
		"\u010d\u0005h\u0000\u0000\u00ff\u010d\u0005x\u0000\u0000\u0100\u010d\u0005"+
		"w\u0000\u0000\u0101\u010d\u0005q\u0000\u0000\u0102\u010d\u0005g\u0000"+
		"\u0000\u0103\u010d\u0005j\u0000\u0000\u0104\u010d\u0005f\u0000\u0000\u0105"+
		"\u010d\u0005d\u0000\u0000\u0106\u010d\u0005e\u0000\u0000\u0107\u010d\u0005"+
		"o\u0000\u0000\u0108\u010d\u0005m\u0000\u0000\u0109\u010d\u0005k\u0000"+
		"\u0000\u010a\u010d\u0005n\u0000\u0000\u010b\u010d\u0003H$\u0000\u010c"+
		"\u00fe\u0001\u0000\u0000\u0000\u010c\u00ff\u0001\u0000\u0000\u0000\u010c"+
		"\u0100\u0001\u0000\u0000\u0000\u010c\u0101\u0001\u0000\u0000\u0000\u010c"+
		"\u0102\u0001\u0000\u0000\u0000\u010c\u0103\u0001\u0000\u0000\u0000\u010c"+
		"\u0104\u0001\u0000\u0000\u0000\u010c\u0105\u0001\u0000\u0000\u0000\u010c"+
		"\u0106\u0001\u0000\u0000\u0000\u010c\u0107\u0001\u0000\u0000\u0000\u010c"+
		"\u0108\u0001\u0000\u0000\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010c"+
		"\u010a\u0001\u0000\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d"+
		"!\u0001\u0000\u0000\u0000\u010e\u010f\u0005l\u0000\u0000\u010f\u0110\u0003"+
		"H$\u0000\u0110\u0111\u0005p\u0000\u0000\u0111#\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0005H\u0000\u0000\u0113\u0114\u0003<\u001e\u0000\u0114%"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0005I\u0000\u0000\u0116\u0119\u0003"+
		"8\u001c\u0000\u0117\u0118\u0007\u0005\u0000\u0000\u0118\u011a\u00038\u001c"+
		"\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000"+
		"\u0000\u011a\'\u0001\u0000\u0000\u0000\u011b\u011d\u0005L\u0000\u0000"+
		"\u011c\u011e\u0005.\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f"+
		"\u011b\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121\u0126\u0007\u0006\u0000\u0000\u0122"+
		"\u0124\u0005K\u0000\u0000\u0123\u0125\u0005\t\u0000\u0000\u0124\u0123"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0127"+
		"\u0001\u0000\u0000\u0000\u0126\u0122\u0001\u0000\u0000\u0000\u0126\u0127"+
		"\u0001\u0000\u0000\u0000\u0127)\u0001\u0000\u0000\u0000\u0128\u012a\u0007"+
		"\u0007\u0000\u0000\u0129\u012b\u0007\b\u0000\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b+\u0001\u0000\u0000"+
		"\u0000\u012c\u012e\u0005\\\u0000\u0000\u012d\u012f\u0005.\u0000\u0000"+
		"\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000"+
		"\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012c\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0153\u0001\u0000\u0000\u0000"+
		"\u0132\u0134\u0005\u0004\u0000\u0000\u0133\u0135\u0007\t\u0000\u0000\u0134"+
		"\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0154\u0001\u0000\u0000\u0000\u0136\u0154\u0005\u0005\u0000\u0000\u0137"+
		"\u0154\u0005\u000b\u0000\u0000\u0138\u0154\u0005\f\u0000\u0000\u0139\u0154"+
		"\u0005\r\u0000\u0000\u013a\u0154\u0005\u000e\u0000\u0000\u013b\u0154\u0005"+
		"\u000f\u0000\u0000\u013c\u0154\u0005\u0010\u0000\u0000\u013d\u0154\u0005"+
		"\u0011\u0000\u0000\u013e\u0154\u0005\u0012\u0000\u0000\u013f\u0154\u0005"+
		"\u0013\u0000\u0000\u0140\u0154\u0005\u0014\u0000\u0000\u0141\u0154\u0005"+
		"\u0015\u0000\u0000\u0142\u0154\u0005\u0016\u0000\u0000\u0143\u0154\u0005"+
		"\u0017\u0000\u0000\u0144\u0154\u0005\u0019\u0000\u0000\u0145\u0154\u0005"+
		"\u001e\u0000\u0000\u0146\u0154\u0005\u001f\u0000\u0000\u0147\u0154\u0005"+
		" \u0000\u0000\u0148\u0154\u0005!\u0000\u0000\u0149\u0154\u0005\'\u0000"+
		"\u0000\u014a\u0154\u0005+\u0000\u0000\u014b\u0154\u00051\u0000\u0000\u014c"+
		"\u0154\u00057\u0000\u0000\u014d\u0154\u0005:\u0000\u0000\u014e\u0154\u0005"+
		"@\u0000\u0000\u014f\u0154\u0005C\u0000\u0000\u0150\u0154\u0005D\u0000"+
		"\u0000\u0151\u0154\u0005G\u0000\u0000\u0152\u0154\u0005S\u0000\u0000\u0153"+
		"\u0132\u0001\u0000\u0000\u0000\u0153\u0136\u0001\u0000\u0000\u0000\u0153"+
		"\u0137\u0001\u0000\u0000\u0000\u0153\u0138\u0001\u0000\u0000\u0000\u0153"+
		"\u0139\u0001\u0000\u0000\u0000\u0153\u013a\u0001\u0000\u0000\u0000\u0153"+
		"\u013b\u0001\u0000\u0000\u0000\u0153\u013c\u0001\u0000\u0000\u0000\u0153"+
		"\u013d\u0001\u0000\u0000\u0000\u0153\u013e\u0001\u0000\u0000\u0000\u0153"+
		"\u013f\u0001\u0000\u0000\u0000\u0153\u0140\u0001\u0000\u0000\u0000\u0153"+
		"\u0141\u0001\u0000\u0000\u0000\u0153\u0142\u0001\u0000\u0000\u0000\u0153"+
		"\u0143\u0001\u0000\u0000\u0000\u0153\u0144\u0001\u0000\u0000\u0000\u0153"+
		"\u0145\u0001\u0000\u0000\u0000\u0153\u0146\u0001\u0000\u0000\u0000\u0153"+
		"\u0147\u0001\u0000\u0000\u0000\u0153\u0148\u0001\u0000\u0000\u0000\u0153"+
		"\u0149\u0001\u0000\u0000\u0000\u0153\u014a\u0001\u0000\u0000\u0000\u0153"+
		"\u014b\u0001\u0000\u0000\u0000\u0153\u014c\u0001\u0000\u0000\u0000\u0153"+
		"\u014d\u0001\u0000\u0000\u0000\u0153\u014e\u0001\u0000\u0000\u0000\u0153"+
		"\u014f\u0001\u0000\u0000\u0000\u0153\u0150\u0001\u0000\u0000\u0000\u0153"+
		"\u0151\u0001\u0000\u0000\u0000\u0153\u0152\u0001\u0000\u0000\u0000\u0154"+
		"-\u0001\u0000\u0000\u0000\u0155\u0157\u0005]\u0000\u0000\u0156\u0158\u0005"+
		".\u0000\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000"+
		"\u0000\u0000\u0158\u015e\u0001\u0000\u0000\u0000\u0159\u015b\u0005^\u0000"+
		"\u0000\u015a\u015c\u0005\u0002\u0000\u0000\u015b\u015a\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015e\u0001\u0000\u0000"+
		"\u0000\u015d\u0155\u0001\u0000\u0000\u0000\u015d\u0159\u0001\u0000\u0000"+
		"\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000"+
		"\u0000\u015f\u0166\u00030\u0018\u0000\u0160\u0162\u0005g\u0000\u0000\u0161"+
		"\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0001\u0000\u0000\u0000\u0163\u0165\u00030\u0018\u0000\u0164\u0161"+
		"\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167/\u0001"+
		"\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016b\u0003"+
		"2\u0019\u0000\u016a\u016c\u00034\u001a\u0000\u016b\u016a\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c1\u0001\u0000\u0000\u0000"+
		"\u016d\u0170\u0003B!\u0000\u016e\u0170\u0003@ \u0000\u016f\u016d\u0001"+
		"\u0000\u0000\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u01703\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0007\u0005\u0000\u0000\u0172\u0173\u0003B!\u0000"+
		"\u01735\u0001\u0000\u0000\u0000\u0174\u0175\u00038\u001c\u0000\u01757"+
		"\u0001\u0000\u0000\u0000\u0176\u0179\u0003<\u001e\u0000\u0177\u0179\u0003"+
		":\u001d\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0177\u0001\u0000"+
		"\u0000\u0000\u01799\u0001\u0000\u0000\u0000\u017a\u017b\u0003@ \u0000"+
		"\u017b;\u0001\u0000\u0000\u0000\u017c\u017d\u0003@ \u0000\u017d=\u0001"+
		"\u0000\u0000\u0000\u017e\u017f\u0003@ \u0000\u017f?\u0001\u0000\u0000"+
		"\u0000\u0180\u0181\u0005x\u0000\u0000\u0181A\u0001\u0000\u0000\u0000\u0182"+
		"\u0189\u0005r\u0000\u0000\u0183\u0189\u0003N\'\u0000\u0184\u0189\u0003"+
		"F#\u0000\u0185\u0189\u0003D\"\u0000\u0186\u0189\u0003J%\u0000\u0187\u0189"+
		"\u0003L&\u0000\u0188\u0182\u0001\u0000\u0000\u0000\u0188\u0183\u0001\u0000"+
		"\u0000\u0000\u0188\u0184\u0001\u0000\u0000\u0000\u0188\u0185\u0001\u0000"+
		"\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0187\u0001\u0000"+
		"\u0000\u0000\u0189C\u0001\u0000\u0000\u0000\u018a\u018b\u0007\n\u0000"+
		"\u0000\u018bE\u0001\u0000\u0000\u0000\u018c\u0190\u0005w\u0000\u0000\u018d"+
		"\u0190\u0005a\u0000\u0000\u018e\u0190\u0003H$\u0000\u018f\u018c\u0001"+
		"\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u018e\u0001"+
		"\u0000\u0000\u0000\u0190G\u0001\u0000\u0000\u0000\u0191\u0192\u0007\u000b"+
		"\u0000\u0000\u0192I\u0001\u0000\u0000\u0000\u0193\u0194\u0005\u001c\u0000"+
		"\u0000\u0194\u0197\u0005l\u0000\u0000\u0195\u0198\u0003@ \u0000\u0196"+
		"\u0198\u0003B!\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0196\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019a\u0005"+
		"p\u0000\u0000\u019aK\u0001\u0000\u0000\u0000\u019b\u019c\u0005\u001d\u0000"+
		"\u0000\u019c\u019f\u0005l\u0000\u0000\u019d\u01a0\u0003@ \u0000\u019e"+
		"\u01a0\u0003B!\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u019f\u019e\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005"+
		"p\u0000\u0000\u01a2M\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\u0001\u0000"+
		"\u0000\u01a4\u01b3\u0003B!\u0000\u01a5\u01b3\u0005)\u0000\u0000\u01a6"+
		"\u01b3\u0005*\u0000\u0000\u01a7\u01b3\u00058\u0000\u0000\u01a8\u01b3\u0005"+
		"9\u0000\u0000\u01a9\u01b3\u0005;\u0000\u0000\u01aa\u01b3\u0005<\u0000"+
		"\u0000\u01ab\u01b3\u0005E\u0000\u0000\u01ac\u01b3\u0005F\u0000\u0000\u01ad"+
		"\u01b3\u0005M\u0000\u0000\u01ae\u01b3\u0005N\u0000\u0000\u01af\u01b3\u0005"+
		"a\u0000\u0000\u01b0\u01b3\u0005b\u0000\u0000\u01b1\u01b3\u0005c\u0000"+
		"\u0000\u01b2\u01a3\u0001\u0000\u0000\u0000\u01b2\u01a5\u0001\u0000\u0000"+
		"\u0000\u01b2\u01a6\u0001\u0000\u0000\u0000\u01b2\u01a7\u0001\u0000\u0000"+
		"\u0000\u01b2\u01a8\u0001\u0000\u0000\u0000\u01b2\u01a9\u0001\u0000\u0000"+
		"\u0000\u01b2\u01aa\u0001\u0000\u0000\u0000\u01b2\u01ab\u0001\u0000\u0000"+
		"\u0000\u01b2\u01ac\u0001\u0000\u0000\u0000\u01b2\u01ad\u0001\u0000\u0000"+
		"\u0000\u01b2\u01ae\u0001\u0000\u0000\u0000\u01b2\u01af\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b3O\u0001\u0000\u0000\u00002V\\a\u0092\u0094\u00a5\u00aa\u00af"+
		"\u00b2\u00b8\u00bd\u00c0\u00c4\u00c7\u00cc\u00d1\u00d4\u00d9\u00db\u00e2"+
		"\u00e5\u00ea\u00ee\u00f5\u00f8\u00fc\u010c\u0119\u011d\u011f\u0124\u0126"+
		"\u012a\u012e\u0130\u0134\u0153\u0157\u015b\u015d\u0161\u0166\u016b\u016f"+
		"\u0178\u0188\u018f\u0197\u019f\u01b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}