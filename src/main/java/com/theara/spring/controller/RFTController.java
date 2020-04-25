package com.theara.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theara.spring.model.MData;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rft/request")
public class RFTController {
	private ObjectMapper objectMapper = new ObjectMapper();

	private int traceNo = 17132;
	private int seqNo = 0;

	@RequestMapping(value = "/accountInquiryChannel", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public MData retrieveOtherBankAccountInfo(HttpServletRequest servletRequest) throws IOException {

		MData request = this.readJsonReq(servletRequest);
		MData response = new MData(request);

		String trxUnqNum = getTransactionUniqueNumber();
		String msgId = String.format("%s%s", "ACMT/", trxUnqNum);

		// Set response
		response.put( "handlingUserId"					, null											);
		response.put( "userDepartment"					, null											);
		response.put( "userJobPosition"					, null											);
		response.put( "handlingUserIp"					, null											);
		response.put( "transactionCode"					, "300000"										);
		response.put( "responseCode"					, "000"											);
		response.put( "traceNo"							, traceNo++	+ ""								);
		response.put( "errorMsg"						, "Normal Complete."							);
		response.put( "senderBankCode"					, "058"											);
		response.put( "transactionUniqueNumber"			, trxUnqNum										);
		response.put( "receiverName"					, "FAKE NAME"									);
		response.put( "senderAccountPinNo"				, null											);
		response.put( "senderFee"						, BigDecimal.valueOf(0.51D)						);
		response.put( "centerFee"						, BigDecimal.ZERO								);
		response.put( "receiverFee"						, BigDecimal.valueOf(0.25D)						);
		response.put( "acmt023MsgId"					, msgId											);
		response.put( "acmt023CreationDateTime"			, getTransactionDateTime()						);
		response.put( "acmt023AssignerBicfi"			, "PPCBKHPPXXX"									);
		response.put( "acmt023AssigneeBicfi"			, "ACLBKHPPXXX"									);
		response.put( "acmt023VerficationId"			, msgId											);
		response.put( "acmt023ReceiverAccountNo"		, request.getString("receiverAccountNo")		);
		response.put( "acmt023ReceiverBicfi"			, "ACLBKHPPXXX"									);
		response.put( "acmt024RmsgId"					, msgId											);
		response.put( "acmt024CreationDateTime"			, getTransactionDateTime()						);
		response.put( "acmt024AssignerBicfi"			, "PPCBKHPPXXX"									);
		response.put( "acmt024AssigneeBicfi"			, "ACLBKHPPXXX"									);
		response.put( "acmt024OriginalMsgId"			, msgId											);
		response.put( "acmt024OriginalCreationDateTime"	, getTransactionDateTime()						);
		response.put( "acmt024RptOriginalId"			, msgId											);
		response.put( "acmt024VerificationContent"		, "TRUE"										);
		response.put( "acmt024OriginalReceiverAccountNo", request.getString("receiverAccountNo")		);
		response.put( "acmt024OriginalReceiverBicfi"	, "ACLBKHPPXXX"									);

		return response;

	}

	@RequestMapping(value = "/fundTransferChannel", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public MData registerOutboundAccountTransfer(HttpServletRequest servletRequest) throws Exception {

		MData request = this.readJsonReq(servletRequest);
		MData response = new MData(request);

		String trxUnqNum = getTransactionUniqueNumber();
		String msgId = String.format("%s%s", "ACMT/", trxUnqNum);
		String currency = request.getString("currency");

		response.put( "handlingUserId"					, null										);
		response.put( "userDepartment"					, null										);
		response.put( "userJobPosition"					, null										);
		response.put( "handlingUserIp"					, null										);
		response.put( "approvalId"						, null										);
		response.put( "approvalIp"						, null										);
		response.put( "transactionCode"					, "100000"									);
		response.put( "responseCode"					, "000"										);
		response.put( "sendDate"						, getSendDate()								);
		response.put( "sendTime"						, getSendTime()								);
		response.put( "traceNo"							, traceNo++ + ""							);
		response.put( "errorMsg"						, null										);
		response.put( "senderBankCode"					, "058"										);
		response.put( "transactionUniqueNumber"			, trxUnqNum									);
		response.put( "senderAccountPinNo"				, null										);
		response.put( "msgId"							, msgId										);
		response.put( "creationDateTime"				, getTransactionDateTime()					);
		response.put( "numberOfTxs"						, 1											);
		response.put( "controlSum"						, request.get("amount")						);
		response.put( "senderBankName"					, "PHNOM PENH COMMERCIAL BANK"				);
		response.put( "paymentInformationId"			, msgId										);
		response.put( "paymentMethod"					, "TRF"										);
		response.put( "requestedExecutionDate"			, getRequestedExecutionDate()				);
		response.put( "debtorName"						, request.getString("senderName")			);
		response.put( "debtorAccountNo"					, null										);
		response.put( "debtorCcy"						, currency									);
		response.put( "debtorBankBicfi"					, "PPCBKHPPXXX"								);
		response.put( "trfTrxInfPaymentId"				, msgId										);
		response.put( "trfTrxInfCcy"					, currency									);
		response.put( "trfTrxInfAmt"					, request.get("amount")						);
		response.put( "chargeBearer"					, "SHAR"									);
		response.put( "creditorBankBicfi"				, "ACLBKHPPXXX"								);
		response.put( "creditorName"					, request.getString("receiverName")			);
		response.put( "creditorAccountNo"				, request.getString("receiverAccountNo")	);
		response.put( "creditorCcy"						, "USD"										);
		response.put( "fundTransferPurpose"				, null										);
		response.put( "remittanceinformation1"			, null										);
		response.put( "remittanceinformation2"			, null										);
		response.put( "remittanceinformation3"			, null										);
		response.put( "remittanceinformation4"			, null										);

		return response;
	}

	@RequestMapping(value = "/passCodeManagement", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public MData registerFundTransferPhoneNumber(HttpServletRequest servletRequest) throws Exception {

		MData request = this.readJsonReq(servletRequest);
		MData response = new MData(request);

		String trxUnqNum = getTransactionUniqueNumber();
		String msgId = String.format("%s%s", "ACMT/", trxUnqNum);
		String currency = request.getString("currency");

		response.put( "handlingUserId"		, null										);
		response.put( "userDepartment"		, null										);
		response.put( "userJobPosition"		, null										);
		response.put( "handlingUserIp"		, null										);
		response.put( "approvalId"			, null										);
		response.put( "approvalIp"			, null										);
		response.put( "responseCode"		, "000"										);
		response.put( "errorMsg"			, "Normal Complete."						);
		response.put( "senderAccountPinNo"	, null										);
		response.put( "senderFee"			, BigDecimal.valueOf(0.51D)					);
		response.put( "centerFee"			, BigDecimal.ZERO							);
		response.put( "receiverFee"			, BigDecimal.valueOf(0.25D)					);
		response.put( "receiverBankCode"	, "058"										);
		response.put( "passCode"			, RandomStringUtils.randomAlphanumeric(6)	);
		response.put( "cancelReason"		, null										);
		response.put( "transactionUniqueNo"	, trxUnqNum									);
		response.put( "traceNo"				, traceNo++ + ""							);

		return response;
	}

	private String getTransactionUniqueNumber() {

		Date date = new Date();
		String dateString = new SimpleDateFormat("yyyyMMdd").format(date);

		return String.format( "%s%s", dateString, StringUtils.leftPad(seqNo++ + "", 9, '0'));

	}

	private String getTransactionDateTime() {
		Date date = new Date();
		return new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").format(date);
	}

	private String getSendDate() {
		Date date = new Date();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	private String getSendTime() {
		Date date = new Date();
		return new SimpleDateFormat("hhmmss").format(date);
	}

	private String getRequestedExecutionDate() {
		Date date = new Date();
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	private MData readJsonReq(HttpServletRequest servletRequest) throws IOException {
		return objectMapper.readValue(servletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())), MData.class);
	}

//	private MData mockRetrieveReceiverAccount( MData input ) throws MBizException {
//
//		if ( !"11111111".equals( input.getString( "receiverAccountNo" ) ) ) {
//			throwMBizException( "120907", "No recipient account" );
//		}
//
//		MData outputData = new MData();
//		outputData.setString( "transactionUniqueNumber", String.format( "0582021%s", this.getMockMilliSecond() ) );
//		outputData.setString( "receiverAccountNo", input.getString( "receiverAccountNo" ) );
//		outputData.setString( "receiverName", "NGOV UYPHENG" );
//		outputData.setString( "currency", "USD" );
//		outputData.setBigDecimal( "inquiryAmount", BigDecimal.valueOf( 100 ) );
//		outputData.setBigDecimal( "senderFee", BigDecimal.valueOf( 0.51 ) );
//		outputData.setBigDecimal( "centerFee", BigDecimal.valueOf( 0 ) );
//		outputData.setBigDecimal( "receiverFee", BigDecimal.valueOf( 0.25 ) );
//
//		return outputData;
//

//	}

//	private MData mockRegisterAccountTransfer() throws MBizException {
//
//		MData outputData = new MData();
//		outputData.setString( "interUniqueId", "" );
//		outputData.setString( "transactionUniqueNumber", String.format( "0582021%s", this.getMockMilliSecond() ) );
//		outputData.setString( "currency", "USD" );
//		outputData.setBigDecimal( "amount", BigDecimal.valueOf( 100 ) );
//		outputData.setBigDecimal( "senderFee", BigDecimal.valueOf( 0.51 ) );
//		outputData.setBigDecimal( "centerFee", BigDecimal.valueOf( 0 ) );
//		outputData.setBigDecimal( "receiverFee", BigDecimal.valueOf( 0.25 ) );
//
//		if (true)
//			throw new MBizException( "120000", "External Other Error" );
//
//		return outputData;
//

//	}

//	private MData mockRegisterPasscode() {
//
//		MData outputData = new MData();
//		outputData.setString( "interUniqueId", "" );
//		outputData.setString( "transactionUniqueNumber", String.format( "0582021%s", this.getMockMilliSecond() ) );
//		outputData.setString( "currency", "USD" );
//		outputData.setString( "passCode", "AABBCC" );
//		outputData.setBigDecimal( "amount", BigDecimal.valueOf( 100 ) );
//		outputData.setBigDecimal( "senderFee", BigDecimal.valueOf( 0.51 ) );
//		outputData.setBigDecimal( "centerFee", BigDecimal.valueOf( 0 ) );
//		outputData.setBigDecimal( "receiverFee", BigDecimal.valueOf( 0.25 ) );
//
//		return outputData;
//
//	}

}
