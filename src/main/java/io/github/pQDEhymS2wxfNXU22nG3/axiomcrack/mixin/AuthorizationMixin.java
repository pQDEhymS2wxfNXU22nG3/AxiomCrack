package io.github.pQDEhymS2wxfNXU22nG3.axiomcrack.mixin;

import com.moulberry.axiom.utils.Authorization;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;

@Mixin(Authorization.class)
public class AuthorizationMixin {
    @Inject(method = "hasCommercialLicense()Z", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hasCommercialLicense(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "checkCommercial", at = @At("HEAD"), cancellable = true, remap = false)
    private static void checkCommercial(CallbackInfoReturnable<CompletableFuture<Boolean>> cir) {
        cir.cancel();
    }

    @Inject(method = "checkServer", at = @At("HEAD"), cancellable = true, remap = false)
    private static void checkServer(CallbackInfoReturnable<CompletableFuture<Boolean>> cir) {
        cir.cancel();
    }
}
