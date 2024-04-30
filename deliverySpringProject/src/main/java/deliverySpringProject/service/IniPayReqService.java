package deliverySpringProject.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.inicis.std.util.SignatureUtil;

import deliverySpringProject.command.PurchaseCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.PurchaseDTO;

@Service
public class IniPayReqService {
	

	public void execute(PurchaseCommand purchaseCommand,Model model) throws Exception {
		
		String mid = "INIpayTest"; // 상점아이디
		String signKey = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS"; // 웹 결제 signkey

		String mKey = SignatureUtil.hash(signKey, "SHA-256");

		String timestamp = SignatureUtil.getTimestamp(); // util에 의해서 자동생성
		//String orderNumber = purchaseNum; // 가맹점 주문번호(가맹점에서 직접 설정)
		String price = String.valueOf(purchaseCommand.getPurchasePrice()); // 상품가격(특수기호 제외, 가맹점에서 직접 설정)

		Map<String, String> signParam = new HashMap<String, String>();

		//signParam.put("oid", "1");
		signParam.put("price", price);
		signParam.put("timestamp", timestamp);

		String signature = SignatureUtil.makeSignature(signParam);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("mid", mid);
		model.addAttribute("signature", signature);
		model.addAttribute("mKey", mKey);
		model.addAttribute("purchaseName", purchaseCommand.getMenuName());
		model.addAttribute("price", price);
		model.addAttribute("buyername", purchaseCommand.getCustomerName());
		model.addAttribute("buyertel", purchaseCommand.getCustomerPhone());
	}
}
